import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class159 implements class112 {
   @ObfuscatedName("x")
   public static final class159 field2593 = new class159(1, 2);
   @ObfuscatedName("b")
   public static final class159 field2594 = new class159(0, 3);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 221274881
   )
   public final int field2596;
   @ObfuscatedName("ec")
   static class80[] field2597;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 50647893
   )
   final int field2598;
   @ObfuscatedName("f")
   public static final class159 field2600 = new class159(2, 0);
   @ObfuscatedName("u")
   public static final class159 field2603 = new class159(3, 1);
   @ObfuscatedName("m")
   static class80 field2605;

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   static void method3193() {
      client var0 = client.field530;
      synchronized(client.field530) {
         Container var1 = client.field530.method3061();
         if(var1 != null) {
            class41.field995 = Math.max(var1.getSize().width, class31.field749);
            class45.field1055 = Math.max(var1.getSize().height, class123.field2032);
            if(class102.field1764 == var1) {
               Insets var2 = class102.field1764.getInsets();
               class41.field995 -= var2.right + var2.left;
               class45.field1055 -= var2.top + var2.bottom;
            }

            if(class41.field995 <= 0) {
               class41.field995 = 1;
            }

            if(class45.field1055 <= 0) {
               class45.field1055 = 1;
            }

            int var10 = client.field501?2:1;
            if(var10 == 1) {
               class30.field708 = client.field502;
               class153.field2274 = client.field381;
            } else {
               class30.field708 = Math.min(class41.field995, 7680);
               class153.field2274 = Math.min(class45.field1055, 2160);
            }

            class144.field2200 = (class41.field995 - class30.field708) / 2;
            class144.field2190 = 0;
            class89.field1567.setSize(class30.field708, class153.field2274);
            int var4 = class30.field708;
            int var5 = class153.field2274;
            Canvas var6 = class89.field1567;

            Object var3;
            try {
               class81 var7 = new class81();
               var7.vmethod1929(var4, var5, var6);
               var3 = var7;
            } catch (Throwable var11) {
               class75 var8 = new class75();
               var8.vmethod1929(var4, var5, var6);
               var3 = var8;
            }

            class12.field196 = (class77)var3;
            if(class102.field1764 == var1) {
               Insets var13 = class102.field1764.getInsets();
               class89.field1567.setLocation(var13.left + class144.field2200, class144.field2190 + var13.top);
            } else {
               class89.field1567.setLocation(class144.field2200, class144.field2190);
            }

            class19.method244();
            if(client.field391 != -1) {
               class37.method805(true);
            }

            class0.method2();
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "69"
   )
   public int vmethod3194() {
      return this.field2598;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class159(int var1, int var2) {
      this.field2596 = var1;
      this.field2598 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;S)I",
      garbageValue = "-500"
   )
   public static int method3197(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
