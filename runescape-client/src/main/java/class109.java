import java.util.HashMap;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class109 {
   @ObfuscatedName("a")
   static int[] field1889;
   @ObfuscatedName("mj")
   static byte field1890;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -544838903
   )
   static int field1894;
   @ObfuscatedName("d")
   static int[] field1895;

   static {
      new HashMap();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2103777177"
   )
   public static void method2417() {
      class140 var0 = class140.field2124;
      synchronized(class140.field2124) {
         class140.field2127 = class140.field2130;
         class140.field2128 = class140.field2125;
         class140.field2126 = class140.field2122;
         class140.field2134 = class140.field2129;
         class140.field2135 = class140.field2131;
         class140.field2136 = class140.field2132;
         class140.field2137 = class140.field2140;
         class140.field2129 = 0;
      }
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZS)Z",
      garbageValue = "0"
   )
   static boolean method2418(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = class75.method1629(var0, client.field278);

         for(int var3 = 0; var3 < client.field348; ++var3) {
            if(var2.equalsIgnoreCase(class75.method1629(client.field428[var3].field239, client.field278))) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class75.method1629(class47.field1053.field58, client.field278))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
