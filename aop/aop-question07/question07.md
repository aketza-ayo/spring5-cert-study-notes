# If shown pointcut expression, would you understand them? For example, what would be the correct pointcut expression to match both getter and setter methods?
Pointcut designator types supported by Spring AOP:
- execution
- within
- args
- bean
- this
- target
- @annotation
- @args
- @within
- @target

Pointcut designator - ```execution``` - matches method execution

General Form:
```exececution([visibility modifiers] [return type] [package].[class].[method]([arguments]) [throws exceptions]```

Description:
- ```[visibility modifiers]``` - public/protected, if omitted all are matched, can be used with negation, for example ```!protected```
- ```[return type]``` - void, primitive or Object type, cannot be omitted, can be used with wildcard *, can be used with
negation, for example ```!int```
- ```[package]``` - package in which class is located, may be omitted if class is located within same package as aspect,
wildcard * may be used to match all packages, wildcard... may be used to match all sub-packages
  
- ```[class]``` - class name to match against, may be omitted, may be used with * wildcard
- ```[arguments]``` - May be empty to match methods without any arguments, may be used with wildcard .. to match zero or more 
arguments, may be used with wildcard * to match all types of specific argument, may be used with ! negation 
  
- ```[throws exceptions]``` - Match method that throws exceptions from given list, can be used with negation !

---

Pointcut designator - ```within``` - matches execution within  specified class/classes, optionally you can specify class package

General Form:
```within([package].[class])```

Description:
- ```[package]``` - package where class is located, may be used with .. wildcard (includes all sub-packages) or with * wildcard, may be omitted.
- ```[class]``` - class against which match should happen, may be used with * wildcard

---

Pointcut designator - ```args``` - matches execution of method with matching arguments 

General Form:
```args([paramter_type1, parameter_type2, ..., parameter_typeN])```

Description:
- ```[parameter_typeN]``` simple or object type, may be * to indicate one parameter of any type, may be .. to indicate
zero or more arguments, you can specify types with the package.
  
---

Pointcut designator - ```bean``` - matches execution of method with matching Spring Bean Name

General Form:
```bean([beanName])```

Description:
- ```[beanName]``` - name of the Spring Bean (automatically generated by framework, or set manually)

---

Pointcut designator - ```this``` - matches execution against type of proxy that was generated by Spring AOP

General Form:
```this([type])```

Description:
- ```[type]``` - type of proxy, matches if generated proxy is of specified type

---

Pointcut designator - ```target``` - matches execution against type of target object invoked by proxy

General Form:
```target([type])```

Description:
- ```[type]``` - type of the target object invoked by proxy, matches if target object is of specified type

In *JDK Proxy* ```this``` is the proxy object and ```target``` is the original object. The client code interacts
with the Dynamically generated Proxy that implements the interface and uses as a composition/delegation the original object.  
The proxy object and the original object are of type of the interface. However, the proxy is not type of the target. 

In *CGLIB Proxy* is different because we use inheritance, that is why```this``` is the proxy which is type of the ```target```

---

Pointcut designator - ```@annotation``` - matches method execution annotated with specified annotation.

General Form:
```@annotation([annotation_type])```

Description:
- ```[annotation_type]``` - type of annotation used to annotated method which should match pointcut expression

---

Pointcut designator - ```@args``` - matches method execution with argument, which types (classes) are annotated with specified
annotation type, note that class should be annotated, not the argument of method itself

General Form:
```@args([annotation_type])```

Description:
- ```[annotation_type]``` - type of annotation used on top of class, which represents type of argument 

---

Pointcut designator - ```@within``` - matches executions inside classes annotated with specified annotations

General Form:
```@within([annotation_type])```

Description:
- ```[annotation_type]``` - type of annotation used on top of class, inside which method execution should be matched

---

Pointcut designator - ```@target``` - matches method executions inside proxied target class that is annotated with 
specified annotation

General Form:
```@target([annotation_type])```

Description:
- ```[annotation_type]``` - type of annotation used on top of proxied class, inside which method execution should be matched

---

Pointcut expressions can be combined with usages of logical operators:
- ! - negation
- || - logical or
- && - logical and

# what would be the correct pointcut expression to match both getter and setter methods?
To match getter and setters, ```execution```, Pointcut expression can be used together with ability to combine them with
logical operators.

Expression that will match getter and setter can look like this:

```execution(* org.spring.cert.beans.EmployeeBean.get*()) || execution(* org.spring.cert.beans.EmployeeBean.set*(*))) ```