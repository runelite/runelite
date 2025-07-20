# Contributing to RuneLite

We'd love for you to contribute to our source code and to make RuneLite even better than it is
today!

Check out the [Developer Guide](https://github.com/runelite/runelite/wiki/Developer-Guide) for setup instructions, and general tips and tricks.

If you want to make or contribute to a plugin hub plugin, this is *not* the correct guide; instead read the plugin hub development guide, which is linked from the developer guide.

Here are the guidelines we'd like you to follow:

 - [Question or Problem?](#question)
 - [Issues and Bugs](#issue)
 - [Submission Guidelines](#submit)
 - [Coding Format](#format)

## <a name="question"></a> Got a Question or Problem?

If you have questions about how to contribute to RuneLite, please join our [Discord](https://runelite.net/discord) server.

## <a name="issue"></a> Found an Issue?

If you find a bug in the source code or a mistake in the documentation, you can help us by
submitting an issue to our [GitHub Repository](https://github.com/runelite/runelite). Even better you can submit a Pull Request
with a fix.

**Please see the [Submission Guidelines](#submit) below.**

## <a name="submit"></a> Submission Guidelines

### Submitting an Issue
Before you submit your issue search the archive, maybe your question was already answered.

If your issue appears to be a bug and hasn't been reported, open a new issue. Help us to maximize
the effort we can spend fixing issues and adding new features, by not reporting duplicate issues.
Providing the following information will increase the chances of your issue being dealt with
quickly:

* **Overview of the Issue** - if an error is being thrown a non-minified stack trace helps
* **Java Version and Operating System** - is this a problem with a specific setup?
* **Reproduce the Error** - provide details, if possible, on how to reproduce the error
* **Related Issues** - has a similar issue been reported before?
* **Suggest a Fix** - if you can't fix the bug yourself, perhaps you can point to what might be causing the problem (line of code or commit)

### Submitting a Pull Request
Before you submit your pull request consider the following guidelines:

* Search [GitHub](https://github.com/runelite/runelite/pulls) for an open or closed Pull Request
  that relates to your submission. You don't want to duplicate effort.
* If adding a feature or enhancement, we recommend you first [start a discussion for
  it](https://github.com/runelite/runelite/discussions) before submitting a Pull Request.
* [Fork](https://help.github.com/articles/fork-a-repo/) this repo.
* [Clone](https://help.github.com/articles/cloning-a-repository/) your copy.
    ```shell
    git clone https://github.com/YOUR_USERNAME/runelite.git
    cd runelite/
    ```
* After cloning, set a new remote [upstream](https://help.github.com/articles/configuring-a-remote-for-a-fork/) (this helps to keep your fork up to date)
    
    ```shell
    git remote add upstream https://github.com/runelite/runelite.git
    ```

* Make your changes in a new git branch:

    ```shell
    git checkout -b my-fix-branch master
    ```

* Create your patch and run appropriate tests.
* Follow our [Coding Format](#format).
* Commit your changes using a descriptive commit message that uses the imperative, present tense: "change" not "changed" nor "changes".

    ```shell
    git commit -a
    ```
  Note: the optional commit `-a` command line option will automatically "add" and "rm" edited files.

* Push your branch to GitHub:

    ```shell
    git push origin my-fix-branch
    ```

In GitHub, send a pull request to `runelite:master`.
If we suggest changes, then:

* Make the required updates.
* Re-run RuneLite and make sure any and all tests are still passing.
* Commit your changes to your branch (e.g. `my-fix-branch`).
* Push the changes to your GitHub repository (this will update your Pull Request).

If the PR gets too outdated we may ask you to rebase and force push to update the PR:

```shell
git fetch upstream
git rebase upstream/master
git push origin my-fix-branch -f
```

That's it! Thank you for your contribution!

#### After your pull request is merged

After your pull request is merged, you can safely delete your branch and pull the changes
from the main (upstream) repository:

* Delete the remote branch on GitHub either through the GitHub web UI or your local shell as follows:

    ```shell
    git push origin --delete my-fix-branch
    ```

* Check out the master branch:

    ```shell
    git checkout master -f
    ```

* Delete the local branch:

    ```shell
    git branch -D my-fix-branch
    ```

* Update your master with the latest upstream version:

    ```shell
    git pull --ff upstream master
    ```

## <a name="format"></a> Coding Format

To ensure consistency throughout the source code, review our [code conventions](https://github.com/runelite/runelite/wiki/Code-Conventions).
