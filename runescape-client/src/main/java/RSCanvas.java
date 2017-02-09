import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("dm")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -1009638523
   )
   protected static int field1755;
   @ObfuscatedName("k")
   Component field1758;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = 293037491
   )
   protected static int field1759;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-6"
   )
   public static String method2070(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class148.method2768(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   public final void update(Graphics var1) {
      this.field1758.update(var1);
   }

   public final void paint(Graphics var1) {
      this.field1758.paint(var1);
   }

   RSCanvas(Component var1) {
      this.field1758 = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Lclass216;",
      garbageValue = "94"
   )
   public static class216 method2072(int var0) {
      class216[] var1 = new class216[]{class216.field3159, class216.field3156, class216.field3155};
      class216[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class216 var4 = var2[var3];
         if(var0 == var4.field3158) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-83567474"
   )
   public static boolean method2075(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
