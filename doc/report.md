# Project Report for Compilers @ Fudan

## Author

Linghao Zhang ([13307130225@fudan.edu.cn](13307130225@fudan.edu.cn))

## Overview

### Functionalities

- Grammar file: `src/MiniJava.g4` √ 

- Output AST √

- Error Handling √
    - Error Reporting √
        - Lexcial Errors √
        - Syntactic Errors √
        - Semantic Errors √
    - Error Recovery X
        - For lexical & syntactic errors, MiniJavaCF uses ANTLR's default recovery strategy, which includes:
            - Single token deletion
            - Single token insertion
            - Sync-and-return
            - ...
        - For semantic errors, MiniJavaCF simply report the error and exits.

- Highlights
    - Support parsing of operator precedence
    - Human-friendly error reporting
    - Comprehensive semantic analysis with type deduction

### Source Codes


## Tools

## Fundamentals of Syntax Analysis

## Workflow

1. Lexical & Syntactic Analysis
2. First pass of Semantic Analysis
    - Build the scope tree
    - 
3. Second pass of Semantic Analysis
    - Check for existences of variable type & method return type  
    - Check for cyclic inheritence
4. Third pass of Semantic Analysis
    - Check for symbol reference
    - Check for type compatibility 

Note that encountring unrecoverable errors in each of these steps will cause MiniJavaCF to exit early.

## Subtlties

### Grammar Expansion

#### Expression

The most significant change MiniJavaCF made to the original MiniJava grammar is about expressions. The motivation here is to support.

Therefore we define `atom` to be expressions that can evaluate to primitive types; while `nonAtom` to be those that can't.


### Scope Design

#### Symbol

#### Scope

#### Lookup

#### Validity

### First Pass: ScopeBuilder

### Second Pass: SymbolChecker

### Third Pass: TypeChecker & TypeEvaluator

### Error Reporting

#### Underlining Errors

#### Suppressing Cascading Errors

#### Polymorphism

## Screenshots

## Discussions

### Limitations

- For now, MiniJavaCF cannot underline errors involving multiple offending tokens.

### Future Works

- Void method
- Multiple declaration
- Inline initialization
- Initialization check
