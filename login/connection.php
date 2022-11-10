<?php
# this file is not used in this method of connecting

$dbhost = "localhost";
$dbuser = "root";           #default user
$dbpass = "your pass here";
$dbname = "accounts_db";

if(!$con = mysqli_connect($dbhost, $dbuser, $dbpass, $dbname, 3307))
{
    die("<- Failed to connect to database ->");
}

?>
