import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class22 extends class28 {
   @ObfuscatedName("nb")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("clanMemberManager")
   static ClanMemberManager clanMemberManager;
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("rasterProvider")
   public static BufferProvider rasterProvider;
   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgy;Lgy;I)V",
      garbageValue = "1524748957"
   )
   void method164(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field480.field478) {
         throw new IllegalStateException("");
      } else {
         super.field391 = var2.readUnsignedByte();
         super.field393 = var2.readUnsignedByte();
         super.field398 = var2.readUnsignedShort();
         super.field389 = var2.readUnsignedShort();
         super.field390 = var2.readUnsignedShort();
         super.field394 = var2.readUnsignedShort();
         super.field393 = Math.min(super.field393, 4);
         super.field388 = new short[1][64][64];
         super.field395 = new short[super.field393][64][64];
         super.field396 = new byte[super.field393][64][64];
         super.field397 = new byte[super.field393][64][64];
         super.field392 = new class31[super.field393][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field477.field470) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field390 && var5 == super.field394) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method214(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public int hashCode() {
      return super.field390 | super.field394 << 8;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return var2.field390 == super.field390 && super.field394 == var2.field394;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(ILcf;ZI)I",
      garbageValue = "1544594520"
   )
   static int method172(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field943 = 250;
         return 1;
      } else {
         return 2;
      }
   }
}
