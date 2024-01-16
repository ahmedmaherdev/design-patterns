package ahmedmaher.designpattern.structural;

public class Adapter {
    public static void main(String[] args) {

        ISVN svnRepo = new SVN();

        GitSVNAdaptor adaptor = new GitSVNAdaptor(svnRepo);
        adaptor.gitClone("https://github.com/test");
        adaptor.gitAdd("file.txt");
        adaptor.gitCommit("first commit");
        adaptor.gitPush();

    }
}

// Target
interface IGit {
    void gitClone(String url);
    void gitAdd(String file);
    void gitCommit(String msg);
    void gitPush();
}

// Concrete Target{
class Git implements IGit{

    @Override
    public void gitClone(String url) {
        System.out.println("git clone " + url);

    }

    @Override
    public void gitAdd(String file) {
        System.out.println("git add " + file);
    }

    @Override
    public void gitCommit(String msg) {
        System.out.println("git commit -m '" + msg + "'");

    }

    @Override
    public void gitPush() {
        System.out.println("git push");
    }
}

// Adaptee
interface ISVN {
    void svnCheckout(String url);
    void svnAdd(String file);
    void svnCommit(String msg);
    void svnUpdate();
}

// Concrete Adaptee
class SVN implements ISVN {

    @Override
    public void svnCheckout(String url) {
        System.out.println("svn checkout " + url);
    }

    @Override
    public void svnAdd(String file) {
        System.out.println("svn add " + file);
    }

    @Override
    public void svnCommit(String msg) {
        System.out.println("svn commit -m '" + msg + "'");
    }

    @Override
    public void svnUpdate() {
        System.out.println("svn update");
    }
}

// Adaptor
class GitSVNAdaptor implements IGit {
    private ISVN svn;

    public GitSVNAdaptor(ISVN svn) {
        this.svn = svn;
    }

    @Override
    public void gitClone(String url) {
        svn.svnCheckout(url);
    }

    @Override
    public void gitAdd(String file) {
        svn.svnAdd(file);
    }

    @Override
    public void gitCommit(String msg) {
        svn.svnCommit(msg);
    }

    @Override
    public void gitPush() {
        svn.svnUpdate();
    }
}


