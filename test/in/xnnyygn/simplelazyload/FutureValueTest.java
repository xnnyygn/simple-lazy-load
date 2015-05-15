package in.xnnyygn.simplelazyload;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Usage presentation.
 * 
 * @author xnnyygn
 */
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
