import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public class class112 {
   @ObfuscatedName("h")
   IndexDataBase field1654;
   @ObfuscatedName("u")
   XHashTable field1655;
   @ObfuscatedName("q")
   XHashTable field1656;
   @ObfuscatedName("i")
   IndexDataBase field1657;
   @ObfuscatedName("gz")
   static ModIcon[] field1658;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass107;",
      garbageValue = "-1405715786"
   )
   class107 method2118(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class107 var7 = (class107)this.field1656.method3615(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.method1970(this.field1657, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1966();
            this.field1656.method3617(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1602.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass107;",
      garbageValue = "45"
   )
   class107 method2119(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class107 var7 = (class107)this.field1656.method3615(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class106 var8 = (class106)this.field1655.method3615(var5);
         if(var8 == null) {
            var8 = class106.method1983(this.field1654, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1655.method3617(var8, var5);
         }

         var7 = var8.method1988(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1656.method3617(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass107;",
      garbageValue = "949184199"
   )
   public class107 method2121(int var1, int[] var2) {
      if(this.field1654.method4223() == 1) {
         return this.method2119(0, var1, var2);
      } else if(this.field1654.method4184(var1) == 1) {
         return this.method2119(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   public class112(IndexDataBase var1, IndexDataBase var2) {
      this.field1655 = new XHashTable(256);
      this.field1656 = new XHashTable(256);
      this.field1657 = var1;
      this.field1654 = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass107;",
      garbageValue = "1982310445"
   )
   public class107 method2126(int var1, int[] var2) {
      if(this.field1657.method4223() == 1) {
         return this.method2118(0, var1, var2);
      } else if(this.field1657.method4184(var1) == 1) {
         return this.method2118(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "641104897"
   )
   static final int method2129(int var0, int var1) {
      int var2 = class11.method48(var0 + '넵', var1 + 91923, 4) - 128 + (class11.method48(var0 + 10294, var1 + '鎽', 2) - 128 >> 1) + (class11.method48(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "860651080"
   )
   static final void method2130(boolean var0) {
      Ignore.method1118();
      ++Client.field938;
      if(Client.field938 >= 50 || var0) {
         Client.field938 = 0;
         if(!Client.field943 && XGrandExchangeOffer.rssocket != null) {
            Client.secretPacketBuffer1.putOpcode(103);

            try {
               XGrandExchangeOffer.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
               Client.secretPacketBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.field943 = true;
            }
         }

      }
   }
}
