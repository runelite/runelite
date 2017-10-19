import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class14 {
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   @Export("pkIcons")
   static SpritePixels[] pkIcons;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = 1470002847
   )
   static int field292;
   @ObfuscatedName("rp")
   @ObfuscatedGetter(
      intValue = -995736971
   )
   static int field300;
   @ObfuscatedName("g")
   String field304;
   @ObfuscatedName("o")
   String field295;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -8704949915974274793L
   )
   public final long field293;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2140382519
   )
   public final int field296;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   public final GrandExchangeOffer field294;

   @ObfuscatedSignature(
      signature = "(Lfz;BI)V"
   )
   class14(Buffer var1, byte var2, int var3) {
      this.field295 = var1.readString();
      this.field304 = var1.readString();
      this.field296 = var1.readUnsignedShort();
      this.field293 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field294 = new GrandExchangeOffer();
      this.field294.method101(2);
      this.field294.method102(var2);
      this.field294.price = var4;
      this.field294.totalQuantity = var5;
      this.field294.quantitySold = 0;
      this.field294.spent = 0;
      this.field294.itemId = var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "902643102"
   )
   public String method84() {
      return this.field295;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1072463974"
   )
   public String method82() {
      return this.field304;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lih;IIIBZB)V",
      garbageValue = "127"
   )
   static void method87(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class238.field3247.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class238.field3244.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class238.field3252.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class238.field3247.put(var8, var6);
                  --class238.field3253;
                  ++class238.field3248;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class238.field3254.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class238.field3247.put(var8, var6);
                  ++class238.field3248;
               } else {
                  class238.field3261.push(var8);
                  class238.field3252.put(var8, var6);
                  ++class238.field3253;
               }

            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;Ljava/lang/String;Ljava/lang/String;B)Ljh;",
      garbageValue = "4"
   )
   public static Font method86(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.getFile(var2);
      int var5 = var0.getChild(var4, var3);
      Font var6;
      if(!class261.method4822(var0, var4, var5)) {
         var6 = null;
      } else {
         byte[] var8 = var1.getConfigData(var4, var5);
         Font var7;
         if(var8 == null) {
            var7 = null;
         } else {
            Font var9 = new Font(var8, class287.field3808, class21.offsetsY, class287.field3806, class56.field700, class114.field1675, class227.spritePixels);
            class249.method4493();
            var7 = var9;
         }

         var6 = var7;
      }

      return var6;
   }
}
