## Code flow
1. Driver.java provides a sample "main" class then can read markdown content 
   from either a file or stdin
   
2. "readers" module provides classes that can read markdown content from various sources
like stdin/file/network and return the parsed Markdown content using classes from "parsers" module
   
3. "parsers" provide classes that can return "MarkDownContent" classes which encapsulate information
on the type of markdown tag and any content which was parsed from the markdown content passed in
   
4. "converters" provide classes that can convert the parsed Markdown content supplied by "parsers"
into another format, for example HTML
   
5. "writers" provide classes that simply take converted content from "converters" and emit it to various
outputs like stdout/file/network
   
## Code Ideology
1. Keep all aspects of the Markdown to HTML conversion process very loosely coupled
2. Does not make any assumptions on the "source" of Markdown content or where they get written
3. Does not make any assumptions on the "output" format, though all the converts provided are for HTML
it's very easy to extend that to other formats if desired
   
4. Does not focus on "accuracy" of parsing/conversion of Markdown but rather the focus is on making it possible 
   to easily iterate on the provided parsers and converters so that they can be made better iteratively and even replaced 
   with very minimal effort if needed
   
5. Makes it very easy to extend the application so that it can handle even more types
   of Markdown syntax. It's as easy as adding a new "parser" and "converted" and registering
   them with Guice (DI system used here)
6. Makes testing extremely easy by making all components easily injectable

## What can be made better?
1. Parsing is very basic and error prone, can be iterated upon
2. Currently, each line is checked across all possible "parsers" to see if it's eligible for parsing which can
have negative performance impact. This can possibly be made smarter
   
3. Extend "readers" and "writers" to allow handling network sources, currently only handles local sources
4. Add elaborate error handling across all stages
5. More comprehensive testing including "negative" tests for not happy paths

## What is handled?

Current implementation only handles the following:

| Markdown                               | HTML                                              |
| -------------------------------------- | ------------------------------------------------- |
| `# Heading 1`                          | `<h1>Heading 1</h1>`                              | 
| `## Heading 2`                         | `<h2>Heading 2</h2>`                              | 
| `...`                                  | `...`                                             | 
| `###### Heading 6`                     | `<h6>Heading 6</h6>`                              | 
| `Unformatted text`                     | `<p>Unformatted text</p>`                         | 
| `[Link text](https://www.example.com)` | `<a href="https://www.example.com">Link text</a>` | 
| `Blank line`                           | `Ignored`                                         | 

## How to run?
Rename markdowntohtml-1.0.change_to_jar to markdowntohtml-1.0.jar
### To run from file
`java -jar markdowntohtml-1.0.jar file <path_to_file/file_name>`
###### Example
`java -jar markdowntohtml-1.0.jar FILE /Users/username/mdtohtml/src/test/resources/testFiles/test1.md`

### To run from stdin
In this mode, the input is processed one line at a time, to end conversion type "STOP"</br>
`java -jar markdowntohtml-1.0.jar stdin`