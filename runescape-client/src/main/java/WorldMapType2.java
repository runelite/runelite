import java.io.IOException;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 963257743
   )
   static int field515;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 598447825
   )
   int field516;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -444137725
   )
   int field517;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1648680003
   )
   int field518;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1489773599
   )
   int field519;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2024503979
   )
   int field520;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = -1992354975
   )
   static int field521;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1043836467
   )
   static int field522;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1029566091
   )
   int field523;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-1045857308"
   )
   public static Object method490(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class176.field2427) {
            try {
               class171 var2 = new class171();
               var2.vmethod3358(var0);
               return var2;
            } catch (Throwable var3) {
               class176.field2427 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "952872297"
   )
   public boolean vmethod696(int var1, int var2, int var3) {
      return var1 >= this.field519 && var1 < this.field516 + this.field519?var2 >> 6 == this.field517 && var3 >> 6 == this.field518:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-106764697"
   )
   public boolean vmethod707(int var1, int var2) {
      return this.field523 == var1 >> 6 && this.field520 == var2 >> 6;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-578749739"
   )
   public int[] vmethod698(int var1, int var2, int var3) {
      if(!this.vmethod696(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field523 * 64 - this.field517 * 64 + var2, var3 + (this.field520 * 64 - this.field518 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-534616457"
   )
   static void method496(String var0, String var1, String var2) {
      class92.loginMessage1 = var0;
      class92.loginMessage2 = var1;
      class92.loginMessage3 = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "730410078"
   )
   public Coordinates vmethod699(int var1, int var2) {
      if(!this.vmethod707(var1, var2)) {
         return null;
      } else {
         int var3 = this.field517 * 64 - this.field523 * 64 + var1;
         int var4 = this.field518 * 64 - this.field520 * 64 + var2;
         return new Coordinates(this.field519, var3, var4);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-56"
   )
   public void vmethod700(Buffer var1) {
      this.field519 = var1.readUnsignedByte();
      this.field516 = var1.readUnsignedByte();
      this.field517 = var1.readUnsignedShort();
      this.field518 = var1.readUnsignedShort();
      this.field523 = var1.readUnsignedShort();
      this.field520 = var1.readUnsignedShort();
      this.method518();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;B)V",
      garbageValue = "-1"
   )
   public void vmethod695(WorldMapData var1) {
      if(var1.field458 > this.field523) {
         var1.field458 = this.field523;
      }

      if(var1.field465 < this.field523) {
         var1.field465 = this.field523;
      }

      if(var1.field456 > this.field520) {
         var1.field456 = this.field520;
      }

      if(var1.field461 < this.field520) {
         var1.field461 = this.field520;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1845619445"
   )
   void method518() {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LRSSocket;ZI)V",
      garbageValue = "141296532"
   )
   public static void method519(RSSocket var0, boolean var1) {
      if(class164.field2337 != null) {
         try {
            class164.field2337.method2981();
         } catch (Exception var6) {
            ;
         }

         class164.field2337 = null;
      }

      class164.field2337 = var0;
      Preferences.method1595(var1);
      class238.field3261.offset = 0;
      class54.field677 = null;
      class224.field2849 = null;
      class238.field3262 = 0;

      while(true) {
         class234 var2 = (class234)class238.field3266.method3518();
         if(var2 == null) {
            while(true) {
               var2 = (class234)class238.field3269.method3518();
               if(var2 == null) {
                  if(class238.field3260 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.putByte(4);
                        var7.putByte(class238.field3260);
                        var7.putShort(0);
                        class164.field2337.queueForWrite(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class164.field2337.method2981();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class238.field3263;
                        class164.field2337 = null;
                     }
                  }

                  class238.field3268 = 0;
                  class238.field3251 = XGrandExchangeOffer.method96();
                  return;
               }

               class238.field3256.method3461(var2);
               class238.field3253.method3516(var2, var2.hash);
               ++class238.field3258;
               --class238.field3250;
            }
         }

         class238.field3252.method3516(var2, var2.hash);
         ++class238.field3259;
         --class238.field3255;
      }
   }
}
