package encapsulation;

import encapsulation.MobileUsage;
import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;

@JExercise(description = "Tests encapsulation.MobileUsage")
@SuppressWarnings("all")
public class MobileUsageTest extends TestCase {
  private MobileUsage mobileUsage;
  
  private MobileUsage _init_mobileUsage() {
    MobileUsage _mobileUsage = new MobileUsage();
    return _mobileUsage;
  }
  
  @Override
  protected void setUp() {
    mobileUsage = _init_mobileUsage();
    
  }
  
  @JExercise(tests = "MobileUsage()", description = "<h3>Konstrukt\u00F8r</h3>Tests \n\t\tinitialization\n")
  public void testConstructor() {
    _test__constructor_transitions0_effect_state(mobileUsage);
    
  }
  
  @JExercise(tests = "MobileUsage();void registerCall(int)", description = "<h3>legger inn en telefonsamtale</h3>Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>ringer i 70 sekunder.: registerCall(70)</li>\n\t\t<li>ringer i negative sekunder: registerCall(-53)</li>\n\t\t<li>\"sjekker uendret tilstand\"</li>\n\t\t</ul>\n")
  public void testCalling() {
    _transition_exprAction__Calling_transitions0_actions0(mobileUsage);
    _test__Calling_transitions0_effect_state(mobileUsage);
    try {
      _transition_exprAction__Calling_transitions1_actions0(mobileUsage);
      fail("IllegalArgumentException should be thrown after registerCall(-53)");
    } catch (Exception e) {
      assertTrue("IllegalArgumentException should be thrown after registerCall(-53)", e instanceof IllegalArgumentException);
    }
    _transition_exprAction__Calling_transitions2_actions0(mobileUsage);
    _test__Calling_transitions2_effect_state(mobileUsage);
    
  }
  
  private void _test__constructor_transitions0_effect_state(final MobileUsage it) {
    _test__constructor_transitions0_effect_state_objectTests0_test(mobileUsage);
    
  }
  
  private void _test__constructor_transitions0_effect_state_objectTests0_test(final MobileUsage it) {
    
    int _callCount = it.getCallCount();
    assertEquals("callCount == 0 failed", 0, _callCount);
    
    int _callSeconds = it.getCallSeconds();
    assertEquals("callSeconds == 0 failed", 0, _callSeconds);
    
    int _messageCount = it.getMessageCount();
    assertEquals("messageCount == 0 failed", 0, _messageCount);
    
    int _bytesReceived = it.getBytesReceived();
    assertEquals("bytesReceived == 0 failed", 0, _bytesReceived);
    
    int _bytesSent = it.getBytesSent();
    assertEquals("bytesSent == 0 failed", 0, _bytesSent);
    
  }
  
  private void _transition_exprAction__Calling_transitions0_actions0(final MobileUsage it) {
    try {
      
      it.registerCall(70);
      } catch (junit.framework.AssertionFailedError error) {
      fail("registerCall(70) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__Calling_transitions0_effect_state(final MobileUsage it) {
    _test__Calling_transitions0_effect_state_objectTests0_test(mobileUsage);
    
  }
  
  private void _test__Calling_transitions0_effect_state_objectTests0_test(final MobileUsage it) {
    
    int _callCount = it.getCallCount();
    assertEquals("callCount == 1 failed after registerCall(70)", 1, _callCount);
    
    int _callSeconds = it.getCallSeconds();
    assertEquals("callSeconds == 70 failed after registerCall(70)", 70, _callSeconds);
    
  }
  
  private void _transition_exprAction__Calling_transitions1_actions0(final MobileUsage it) {
    try {
      
      int _minus = (-53);
      it.registerCall(_minus);
      } catch (junit.framework.AssertionFailedError error) {
      fail("registerCall(-53) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__Calling_transitions2_actions0(final MobileUsage it) {
    try {
      
      /* "sjekker uendret tilstand" */
      } catch (junit.framework.AssertionFailedError error) {
      fail("\"sjekker uendret tilstand\" failed: " + error.getMessage());
    }
    
  }
  
  private void _test__Calling_transitions2_effect_state(final MobileUsage it) {
    _test__Calling_transitions2_effect_state_objectTests0_test(mobileUsage);
    
  }
  
  private void _test__Calling_transitions2_effect_state_objectTests0_test(final MobileUsage it) {
    
    int _callCount = it.getCallCount();
    assertEquals("callCount == 1 failed after \"sjekker uendret tilstand\"", 1, _callCount);
    
    int _callSeconds = it.getCallSeconds();
    assertEquals("callSeconds == 70 failed after \"sjekker uendret tilstand\"", 70, _callSeconds);
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(MobileUsageTest.class);
  }
}
