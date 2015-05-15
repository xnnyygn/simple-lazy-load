# Simple Lazy Load #

a simple solution for lazy load in Java

## Quick Start ##

 
    public class FutureValueTest {

      class DomainModel {
        private Option<String> name;

        public String getName() {
          return OptionUtils.get(name);
        }

        public void setName(Option<String> name) {
          this.name = name;
        }

        public void setName(String name) {
          this.name = OptionUtils.of(name);
        }
      }

      @Test
      public void test() {
        final String name = "Hello, world!";

        DomainModel model = new DomainModel();
        model.setName(FutureValue.of(new Function0<String>() {

          @Override
          public String apply() {
            System.out.println("load name");
            return name;
          }
        }));

        assertEquals(name, model.getName()); // output "load name" here
        assertEquals(name, model.getName()); // name is loaded
      }
    }

## Core Concept ##

1. FutureValue
2. Function0
3. Option/None/Some

`FutureValue` is the core object in this simple solution. This object implement the method `get` in the interface `Option` with lazy load strategy. You can define your own loader implementation in `Function0` and combine it with `FutureValue` by creating an instance using the static method `FutureValue#of(Function0)`.

`Function0` is just a callback interface since there's no appropriate interface in pure Java and many frameworks have to create it by themselves and so do I.

`Option` and related implmentation `None` and `Some` is the idea from my favorite Programming language, Scala. Scala make it a rule to avoid `null` by using `None`, but you will find it is difficult to just move this concept from Scala to Java due to the way Java programmers test if object is empty or not, which means changing the convention is hard.

Anyway, compared with using the proxy object in this situtation, I found it's easier to implement lazy load by   modifying your model a little and introducing `FutureValue`.

## Limitation ##

As you can see, you have to modify your domain model to use this simple lazy load solution. If your project don't allow you to change the domain model, for example, a very old school project and some models with a long histroy, please refer to `Hibernate` for more information. `Hibernate` provides you with more options to adapt the old models and projects.

As this solution is very simple, you can adapt it very quickly but you should notice that there's no concurrent control in `FutureValue`, make sure your models not using by multiple threads and you will have a very nice weekend. :)
