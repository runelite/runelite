import java.awt.Component;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class22 extends class119 {
   @ObfuscatedName("qj")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -1777400769
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("rz")
   protected static Image field233;
   @ObfuscatedName("az")
   static class184 field238;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-161234916"
   )
   protected boolean vmethod2360(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field1854 && super.field1849 == var3;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "-1580711262"
   )
   static final int method219(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class84.field1432[1024 * var2 / var3] >> 1;
      return (var1 * var4 >> 16) + ((65536 - var4) * var0 >> 16);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)LBufferProvider;",
      garbageValue = "46679655"
   )
   public static BufferProvider method223(int var0, int var1, Component var2) {
      try {
         MainBufferProvider var3 = new MainBufferProvider();
         var3.init(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         SecondaryBufferProvider var4 = new SecondaryBufferProvider();
         var4.init(var0, var1, var2);
         return var4;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "248191101"
   )
   static final void method224() {
      if(Client.field568 != null) {
         Client.field568.method1112();
      }

      if(class3.field30 != null) {
         class3.field30.method1112();
      }

   }
}
