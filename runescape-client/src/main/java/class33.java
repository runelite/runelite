import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class33 {
   @ObfuscatedName("y")
   static boolean field450;
   @ObfuscatedName("m")
   String field447;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 664460117
   )
   int field448;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 412726805
   )
   int field445;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lf;"
   )
   class24 field446;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILf;)V"
   )
   class33(String var1, int var2, int var3, class24 var4) {
      this.field447 = var1;
      this.field448 = var2;
      this.field445 = var3;
      this.field446 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-1673835946"
   )
   public static void method396(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "77"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class273.field3719[var6 - 128];
               if(var7 == 0) {
                  var7 = '?';
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILcw;ZI)I",
      garbageValue = "-602185808"
   )
   static int method395(int var0, Script var1, boolean var2) {
      Widget var3 = PendingSpawn.method1612(class82.intStack[--class56.intStackSize]);
      if(var0 == 2800) {
         class82.intStack[++class56.intStackSize - 1] = GraphicsObject.method1747(Preferences.getWidgetConfig(var3));
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.name == null) {
               class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
            } else {
               class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = class82.intStack[--class56.intStackSize];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var3.actions[var4];
         } else {
            class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }
}
