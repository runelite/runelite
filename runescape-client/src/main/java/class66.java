import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
public class class66 {
   @ObfuscatedName("a")
   static final class66 field809;
   @ObfuscatedName("j")
   static final class66 field808;
   @ObfuscatedName("n")
   static final class66 field810;
   @ObfuscatedName("ik")
   static Widget field813;
   @ObfuscatedName("d")
   @Export("userHome")
   public static String userHome;
   @ObfuscatedName("r")
   static final class66 field811;

   static {
      field809 = new class66();
      field808 = new class66();
      field810 = new class66();
      field811 = new class66();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-14"
   )
   public static void method1086() {
      if(MouseInput.mouse != null) {
         MouseInput var0 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LModIcon;B)V",
      garbageValue = "-34"
   )
   static final void method1084(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < Spotanim.field3339.length; ++var2) {
         Spotanim.field3339[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         Spotanim.field3339[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class18.field323[var5] = (Spotanim.field3339[var5 + 128] + Spotanim.field3339[var5 - 128] + Spotanim.field3339[var5 + 1] + Spotanim.field3339[var5 - 1]) / 4;
            }
         }

         int[] var8 = Spotanim.field3339;
         Spotanim.field3339 = class18.field323;
         class18.field323 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + 16 + var0.offsetX;
                  int var6 = var3 + 16 + var0.offsetY;
                  int var7 = var5 + (var6 << 7);
                  Spotanim.field3339[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1154879824"
   )
   static void method1085() {
      if(Client.spellSelected) {
         Widget var0 = class12.method70(class41.field550, Client.field1062);
         if(var0 != null && var0.field2745 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.field839 = var0.field2745;
            class89.method1689(var1);
         }

         Client.spellSelected = false;
         class48.method749(var0);
      }
   }
}
