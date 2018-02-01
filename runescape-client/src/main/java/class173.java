import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class173 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static final class173 field2395;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static final class173 field2389;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static final class173 field2390;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static final class173 field2391;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static final class173 field2392;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static final class173 field2393;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static final class173 field2394;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static final class173 field2397;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static final class173 field2396;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static final class173 field2388;

   static {
      field2395 = new class173(7);
      field2389 = new class173(15);
      field2390 = new class173(14);
      field2391 = new class173(6);
      field2392 = new class173(5);
      field2393 = new class173(3);
      field2394 = new class173(4);
      field2397 = new class173(5);
      field2396 = new class173(4);
      field2388 = new class173(2);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "7"
   )
   class173(int var1) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-2062328855"
   )
   static final void method3299(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2864(var0, var1, var2);
      int[] var8 = Region.method2864(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-1993447978"
   )
   @Export("byteArrayToObject")
   public static Object byteArrayToObject(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.directBufferUnavailable) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.directBufferUnavailable = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Ldj;B)V",
      garbageValue = "-11"
   )
   static final void method3300(TaskDataNode var0) {
      var0.field1598 = false;
      if(var0.data != null) {
         var0.data.int1 = 0;
      }

      for(TaskDataNode var1 = var0.vmethod4155(); var1 != null; var1 = var0.vmethod4141()) {
         method3300(var1);
      }

   }
}
