# What is meant by application context?

## Overview:
Application context is a central part of spring applications
It allows you to retrieve assembled and configured beans.

## Application context does the following:
- Initiates, configures and assembles the beans
- Manages the bean life cycle
- Is a bean factory
- Is a resource loader
- Pushes event to register event listener
- Exposes env which allows to resolve properties

## Types:
- AnnotationConfigApplicationContext
- AnnotationConfigWebApplicationContext
- ClassPathXmlApplicationContext
- FileSystemXmlApplicationContent
- XmlWebApplicationContext
