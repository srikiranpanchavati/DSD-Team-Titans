import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand.ListMode;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.treewalk.TreeWalk;

import edu.asu.se.model.BranchDetails;
import edu.asu.se.model.FileActivityDetails;

public class gitResult {

	/**
	 * @param args
	 * @throws IOException
	 * @throws GitAPIException
	 */
	public static void main(String[] args) throws IOException, GitAPIException {

		FileRepositoryBuilder builder = new FileRepositoryBuilder();

		Repository repository = builder.setGitDir(new File("C:/Users/rathnakarreddy/git/DSD-Team-Titans/.git"))
				.readEnvironment().findGitDir().build();

		listRepositoryContents(repository);

		// Close repo
		repository.close();

	}

	private static void listRepositoryContents(Repository repository) throws IOException, GitAPIException {

		Git git = new Git(repository);
		int count = 0;
		List<Ref> call = git.branchList().setListMode(ListMode.ALL).call();
		// List<Ref> call = git.tagList().;
		for (Ref ref : call) {
			Ref head = repository.getRef(ref.getName());

			// a RevWalk allows to walk over commits based on some filtering
			// that is
			// defined
			RevWalk walk = new RevWalk(repository);

			RevCommit commit = walk.parseCommit(head.getObjectId());
			RevTree tree = commit.getTree();

			String fullPath = ref.getName();
			int index = fullPath.lastIndexOf("/");
			String branchName = fullPath.substring(index + 1);
			System.out.println("Having tree: " + tree + branchName);

			BranchDetails branch = new BranchDetails();
			branch.setBranchName(branchName);

			// Date date =
			// walk.parseCommit(head.getObjectId()).getAuthorIdent().getWhen();
			// RevTag t = new RevTag()
			// Date date =
			// walk.parseTag(ref.getObjectId()).getTaggerIdent().getWhen();
			// Date d1 = tag.getTaggerIdent().getWhen();
			// RevTag d2 = walk.parseTag(ref.getObjectId());

			// System.out.println("created :" + date);
			// now use a TreeWalk to iterate over all files in the Tree
			// recursively
			// you can set Filters to narrow down the results if needed
			TreeWalk treeWalk = new TreeWalk(repository);
			treeWalk.addTree(tree);
			treeWalk.setRecursive(true);
			while (treeWalk.next()) {
				System.out.println("found: " + treeWalk.getPathString());
				// System.out.println("found: " + treeWalk.getPathString());
				Iterable<RevCommit> logs = git.log().call();
				logs = git.log()
						// for all log.all()
						.addPath(treeWalk.getPathString()).call();
				count = 0;
				String createdDate = "0";
				String name = "0";
				for (RevCommit rev : logs) {
					 System.out.println("Commit: " + rev + ", name: " +
					 rev.getAuthorIdent().getEmailAddress() + ", id: "
					 + rev.getId().getName() + "time: " +
					 rev.getAuthorIdent().getWhen());
					 createdDate = rev.getAuthorIdent().getWhen().toString();
					 name = rev.getAuthorIdent().getName();
					count++;
				}
				System.out.println("Had " + count + " commits on " + treeWalk.getPathString());
				String file = treeWalk.getPathString();
				int ind = fullPath.lastIndexOf("/");
				String fileName = fullPath.substring(index + 1);
				String filePath = fullPath.substring(0, index);
				
				
				FileActivityDetails f = new FileActivityDetails();
				f.setFileName(fileName);
				f.setFilePath(filePath);
				f.setCreatedDate(createdDate);
				//System.out.println(createdDate);
				f.setCommits(count);
				f.setLastCommittedBy(name);
				//System.out.println(name);
				
				
				
			}
		}

	}

}