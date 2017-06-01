import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
public class class241 extends CacheableNode {
   @ObfuscatedName("i")
   static IndexDataBase field3282;
   @ObfuscatedName("e")
   public static NodeCache field3284;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1701171289
   )
   public int field3285;
   @ObfuscatedName("z")
   public static class103 field3287;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1337628191
   )
   public static int field3288;

   class241() {
      this.field3285 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "63"
   )
   void method4282(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field3285 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "30026"
   )
   void method4291(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4282(var1, var2);
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lclass154;IIB)Lclass109;",
      garbageValue = "-33"
   )
   public static final class109 method4293(class154 var0, int var1, int var2) {
      if(class109.field1640 == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            class109 var3 = field3287.vmethod1916();
            var3.field1641 = new int[256 * (class275.field3732?2:1)];
            var3.field1646 = var2;
            var3.vmethod2019();
            var3.field1649 = (var2 & -1024) + 1024;
            if(var3.field1649 > 16384) {
               var3.field1649 = 16384;
            }

            var3.vmethod2020(var3.field1649);
            if(WorldMapType2.field522 > 0 && class109.field1654 == null) {
               class109.field1654 = new class111();
               class109.field1639 = Executors.newScheduledThreadPool(1);
               class109.field1639.scheduleAtFixedRate(class109.field1654, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class109.field1654 != null) {
               if(class109.field1654.field1675[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class109.field1654.field1675[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new class109();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   static {
      field3284 = new NodeCache(64);
   }
}
