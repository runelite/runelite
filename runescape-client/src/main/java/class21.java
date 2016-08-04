import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class21 implements class115 {
   @ObfuscatedName("g")
   static final class21 field587 = new class21(1);
   @ObfuscatedName("r")
   static final class21 field588 = new class21(2);
   @ObfuscatedName("e")
   static final class21 field589 = new class21(3);
   @ObfuscatedName("l")
   static final class21 field590 = new class21(0);
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 192897651
   )
   @Export("baseY")
   static int field592;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1863549427
   )
   final int field594;

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)Lclass80;",
      garbageValue = "1257736555"
   )
   public static class80 method573(int var0, int var1, Component var2) {
      try {
         class84 var3 = new class84();
         var3.vmethod1964(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         class78 var4 = new class78();
         var4.vmethod1964(var0, var1, var2);
         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1633970528"
   )
   public int vmethod3316() {
      return this.field594;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class21(int var1) {
      this.field594 = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2009369946"
   )
   static void method581() {
      class15.field225 = new class199(32);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "296466018"
   )
   public static void method582(Component var0) {
      var0.removeKeyListener(class140.field2157);
      var0.removeFocusListener(class140.field2157);
      class140.field2168 = -1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IZI)Ljava/lang/String;",
      garbageValue = "56448612"
   )
   public static String method583(int var0, boolean var1) {
      return var1 && var0 >= 0?class114.method2539(var0, 10, var1):Integer.toString(var0);
   }
}
