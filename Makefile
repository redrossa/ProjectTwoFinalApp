CP := -cp "opencsv-5.3.jar:commons-text-1.9.jar:commons-logging-1.2.jar:commons-lang3-3.11.jar:comomons-collections-3.2.2.jar:commons-collections4-4.4.jar:commons-beanutils-1.9.4.jar:"

default: run

run: compile
	java $(CP) Main nbaplayers.csv

Main.class: Main.java Frontend.java
	javac $(CP) Main.java
	javac $(CP) Frontend.java

Frontend.class: Backend.java BackendInterface.java
	javac $(CP) Backend.java
	javac $(CP) BackendInterface.java

Backend.class: PlayerInterface.java PlayerDataReader.java RedBlackTree.java 
	javac $(CP) PlayerInterface.java
	javac $(CP) PlayerDataReader.java
	javac $(CP) RedBlackTree.java
	
PlayerDataReader.class: Player.java PlayerDataReader.java
	javac $(CP) Player.java
	javac $(CP) PlayerDataReader.java

compile: Main.class Frontend.class Backend.class PlayerDataReader.class

test: testData testBackend testFrontend

testFrontend: TestFrontEnd1.class TestFrontEnd2.class TestFrontEnd3.class TestFrontEnd4.class
	java $(CP) TestFrontEnd1
	java $(CP) TestFrontEnd2
	java $(CP) TestFrontEnd3
	java $(CP) TestFrontEnd4
	
TestFrontEnd1.class: TestFrontEnd1.java 
	java $(CP) TestFrontEnd1.java
	
TestFrontEnd2.class: TestFrontEnd2.java 
	java $(CP) TestFrontEnd2.java
	
TestFrontEnd3.class: TestFrontEnd3.java 
	java $(CP) TestFrontEnd3.java

TestFrontEnd4.class: TestFrontEnd4.java 
	java $(CP) TestFrontEnd4.java
	
testBackend: BackEndDeveloperTests.class
	java $(CP) TestBackend

BackEndDeveloperTests.class: BackEndDeveloperTests.java
	javac $(CP) BackEndDeveloperTests.java

testData: PlayerDataReader.class DataWranglerTests.class
	java $(CP) DataWranglerTests

DataWranglerTests.class: DataWranglerTests.java
	javac $(CP) DataWranglerTests.java
	
clean:
	$(RM) *.class
