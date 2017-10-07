import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class1 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   static final class1 field8;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   static final class1 field1;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   static final class1 field2;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   static final class1 field3;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   static final class1 field13;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   static final class1 field0;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   static final class1 field6;
   @ObfuscatedName("os")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("n")
   static int[] field10;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1768765237
   )
   final int field7;

   static {
      field8 = new class1(5);
      field1 = new class1(4);
      field2 = new class1(6);
      field3 = new class1(2);
      field13 = new class1(1);
      field0 = new class1(0);
      field6 = new class1(3);
   }

   class1(int var1) {
      this.field7 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-366756684"
   )
   static void method3(String var0, String var1, String var2) {
      class90.loginMessage1 = var0;
      class90.loginMessage2 = var1;
      class90.loginMessage3 = var2;
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Lhj;IIII)V",
      garbageValue = "-1464901598"
   )
   static final void method1(Widget var0, int var1, int var2, int var3) {
      class210 var4 = var0.method4117(false);
      if(var4 != null) {
         if(Client.field1183 < 3) {
            class15.compass.method5186(var1, var2, var4.field2615, var4.field2611, 25, 25, Client.mapAngle, 256, var4.field2616, var4.field2613);
         } else {
            Rasterizer2D.method5068(var1, var2, 0, var4.field2616, var4.field2613);
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-6"
   )
   public static final boolean method0() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field665 == KeyFocusListener.field666) {
            return false;
         } else {
            class94.field1491 = KeyFocusListener.field643[KeyFocusListener.field666];
            ChatLineBuffer.field1546 = KeyFocusListener.field659[KeyFocusListener.field666];
            KeyFocusListener.field666 = KeyFocusListener.field666 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "756305658"
   )
   public static int method2(int var0) {
      return var0 >> 11 & 63;
   }
}
