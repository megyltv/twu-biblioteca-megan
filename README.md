# Biblioteca

Biblioteca is a new system which implements a Library Management System for  the Bangalore Public Library.

## Table of contents

- [Usage of the Application](#usage-of-the-application)
- [Tools Used](#tools-used)
- [Instructions to download code](#instructions-to-download-code)
- [Instructions to open your code in Intellij](#instructions-to-open-your-code)

## Usage
In this section it would be explain the usage of the application. The apllication launch with a welcome message and will ask to enter the credentials in order to begin.

### Credentials
The application has to types or roles for user: librarian and costumer. As the credentials are predefined for users, they are the following.
1. Librarian

    ID User | Password
    --- | ---
    123-1235 | passwd

2. Costumer

    ID User | Password
    --- | ---
    123-1236 | passwd1
    123-1237 | passwd2

### Menu Costumer
A menu with four options will be listed when the user logged has the role of Costumer.
1. **List Books.-** The list of current books available in the library wiil be list and showed to the user.
[Submenu of *List Books* and *List Movies*](#submenu-of-list-books-and-list-movies)
2. **List Movies.-** The list of current movies available in the library wiil be list and showed to the user.
[Submenu of *List Books* and *List Movies*](#submenu-of-list-books-and-list-movies)
3. **User Information.-** This options lists the information of the user logged.
It shows:

        - ID of Library of User
        - Name of User
        - Email of User
        - Phone Number

4. **Log out.-** This option permits the user to logged out.

##### Submenu of *List Books* and *List Movies*
1. **Checkout (Book/Movie).-** For checking out an item, the application will ask to enter the name of the item.
If the name was written correctly, it will show a successful message:
   ```
   Thank you! Enjoy the item
   ```
    If the name was with error, it will show an error message and the user will be guided to the previous message.
    ```
   That item is not available
   ```

2. **Return (Book/Movie).-** For returning an item, the application will ask to enter the name of the item.
If the name of the item was written correctly and belongs to the library, it will will show a successful message:
    ```
   Thank you for returning the item
   ```
    If the name was written with error or the item doesn't belong to the library, it will show an error message and the user will be guided to the previous menu.
    ```
    That is not a valid item to return
    ```

3. **Back.-** This options permits the user return to the previous menu.

### Menu Librarian
A menu with two options will appear when the user logged has the role of Librarian.
1. **Items Checked Out.-** If there is any item that has been checked out, this option will listed. This option permits the librarian to see a log of all the items that has been checked out in any moment with the user's information.
This list is separated by type of item (book, movie).

2. **Log out.-** This option permits the user to logged out.

## Tools used

* Java 8
* JUnit 4
* IDE: IntelliJ

## Instructions to download code

1. Download git and install it.
2. Open a terminal and proceed to clone project
```
git clone "WEB URL OF REPOSITORY"
```
3. If you download: Run 'git init' in the folder that was extracted from the downloaded .zip file, in order to
 initialize local repository.
```
git init
```

3. Make a local commit.
    $ git add -A
    $ git commit -m “Initial commit”

(Dont forget to add the hidden .idea folder, as it will make opening your project in Intellij easier.)

4. After you are done with the local commit, you can share your code with "The World" by pushing it to your
 GitHub repository.
    $ git remote add origin https://github.com/<YOUR-GITHUB-USERNAME>/twu-biblioteca-<YOURNAME>
    $ git push origin master

## Instructions to open your code in Intellij

1. Go to File -> Open (or Open Project)
2. Select the directory containing the code
DONE !


