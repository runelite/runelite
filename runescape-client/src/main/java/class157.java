import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class157 {
   @ObfuscatedName("w")
   public static boolean field2248;
   @ObfuscatedName("q")
   static Hashtable field2246;
   @ObfuscatedName("s")
   public static File field2245;

   static {
      field2248 = false;
      field2246 = new Hashtable(16);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1589346319"
   )
   static String method3022() {
      return class70.preferences.field1305?class45.method653(class90.username):class90.username;
   }
}
