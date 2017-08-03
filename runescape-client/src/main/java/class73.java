import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class73 extends class163 {
   @ObfuscatedName("k")
   static String[] field853;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -29924401
   )
   static int field854;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Widget field851;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILfl;B)Z",
      garbageValue = "1"
   )
   public boolean vmethod3102(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2288 && var3 == super.field2284;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "16711935"
   )
   static final int method1138(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "([Lhn;II)V",
      garbageValue = "305718919"
   )
   static final void method1143(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method1143(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  class14.method86(var4.id, var1);
               }
            }

            ScriptEvent var5;
            if(var1 == 0 && var3.field2685 != null) {
               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.field818 = var3.field2685;
               Ignore.method1126(var5);
            }

            if(var1 == 1 && var3.field2645 != null) {
               if(var3.index >= 0) {
                  Widget var6 = WallObject.method2901(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.field818 = var3.field2645;
               Ignore.method1126(var5);
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "31"
   )
   public static String method1144(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = WorldListFetcher.method1528(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
