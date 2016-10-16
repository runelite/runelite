import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("s")
   @Export("username")
   String username;
   @ObfuscatedName("z")
   String field609;
   @ObfuscatedName("y")
   @Export("rank")
   byte rank;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -854003885
   )
   @Export("world")
   int world;
   @ObfuscatedName("p")
   static int[] field612;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -2035544023
   )
   protected static int field613;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -1054216859
   )
   static int field614;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "16777215"
   )
   static int method589(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var0));
      return null == var1?0:var1.method664();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass171;IIIBZI)V",
      garbageValue = "-1558542130"
   )
   static void method590(class171 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class175 var8 = (class175)class174.field2773.method3775(var6);
      if(null == var8) {
         var8 = (class175)class174.field2765.method3775(var6);
         if(var8 == null) {
            var8 = (class175)class174.field2770.method3775(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3894();
                  class174.field2773.method3776(var8, var6);
                  --class174.field2774;
                  ++class174.field2766;
               }

            } else {
               if(!var5) {
                  var8 = (class175)class174.field2771.method3775(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class175();
               var8.field2785 = var0;
               var8.field2782 = var3;
               var8.field2783 = var4;
               if(var5) {
                  class174.field2773.method3776(var8, var6);
                  ++class174.field2766;
               } else {
                  class174.field2769.method3872(var8);
                  class174.field2770.method3776(var8, var6);
                  ++class174.field2774;
               }

            }
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "37"
   )
   public static Class method591(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-382639292"
   )
   static final String method592(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class188.method3706('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class188.method3706(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class188.method3706(16776960) + var1 + "</col>");
   }
}
