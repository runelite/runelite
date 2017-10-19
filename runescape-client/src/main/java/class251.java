import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
public class class251 extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   static NodeCache field3387;
   @ObfuscatedName("pp")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   static class114 field3390;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field3392;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field3385;
   @ObfuscatedName("q")
   char field3384;
   @ObfuscatedName("v")
   boolean field3389;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 38985783
   )
   public int field3386;
   @ObfuscatedName("g")
   public String field3388;

   static {
      field3387 = new NodeCache(64);
   }

   class251() {
      this.field3389 = true;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfz;II)V",
      garbageValue = "-1321488207"
   )
   void method4509(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3384 = class96.method1879(var1.readByte());
      } else if(var2 == 2) {
         this.field3386 = var1.readInt();
      } else if(var2 == 4) {
         this.field3389 = false;
      } else if(var2 == 5) {
         this.field3388 = var1.readString();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1019538539"
   )
   public boolean method4510() {
      return this.field3384 == 's';
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1889035302"
   )
   void method4507() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfz;I)V",
      garbageValue = "-124268171"
   )
   void method4508(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4509(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-902486879"
   )
   public static byte[] method4530() {
      byte[] var0 = new byte[24];

      try {
         class155.field2240.seek(0L);
         class155.field2240.read(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }
}
