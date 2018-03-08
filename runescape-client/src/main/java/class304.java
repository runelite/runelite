import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
public class class304 extends NameableContainer {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   final JagexLoginType field3853;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 768810271
   )
   int field3851;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   public class220 field3852;

   @ObfuscatedSignature(
      signature = "(Llu;)V"
   )
   public class304(JagexLoginType var1) {
      super(400);
      this.field3851 = 1;
      this.field3852 = new class220();
      this.field3853 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Lkv;",
      garbageValue = "-21"
   )
   Nameable vmethod5446() {
      return new Friend();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[Lkv;",
      garbageValue = "-827789091"
   )
   Nameable[] vmethod5470(int var1) {
      return new Friend[var1];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lkb;ZS)Z",
      garbageValue = "20540"
   )
   public boolean method5416(Name var1, boolean var2) {
      Friend var3 = (Friend)this.method5301(var1);
      return var3 == null?false:!var2 || var3.world != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "908033582"
   )
   public void method5412(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            boolean var3 = var1.readUnsignedByte() == 1;
            Name var4 = new Name(var1.readString(), this.field3853);
            Name var5 = new Name(var1.readString(), this.field3853);
            int var6 = var1.readUnsignedShort();
            int var7 = var1.readUnsignedByte();
            int var8 = var1.readUnsignedByte();
            boolean var9 = (var8 & 2) != 0;
            boolean var10 = (var8 & 1) != 0;
            if(var6 > 0) {
               var1.readString();
               var1.readUnsignedByte();
               var1.readInt();
            }

            var1.readString();
            if(var4 != null && var4.method5418()) {
               Friend var11 = (Friend)this.method5302(var3?var5:var4);
               if(var11 != null) {
                  this.method5352(var11, var4, var5);
                  if(var6 != var11.world) {
                     boolean var12 = true;

                     for(class308 var13 = (class308)this.field3852.method4084(); var13 != null; var13 = (class308)this.field3852.method4085()) {
                        if(var13.field3872.equals(var4)) {
                           if(var6 != 0 && var13.field3873 == 0) {
                              var13.method4093();
                              var12 = false;
                           } else if(var6 == 0 && var13.field3873 != 0) {
                              var13.method4093();
                              var12 = false;
                           }
                        }
                     }

                     if(var12) {
                        this.field3852.method4083(new class308(var4, var6));
                     }
                  }
               } else {
                  if(this.getCount() >= 400) {
                     continue;
                  }

                  var11 = (Friend)this.method5307(var4, var5);
               }

               if(var6 != var11.world) {
                  var11.field3842 = ++this.field3851 - 1;
                  if(var11.world == -1 && var6 == 0) {
                     var11.field3842 = -(var11.field3842 * 410700773) * -1324713491;
                  }

                  var11.world = var6;
               }

               var11.rank = var7;
               var11.field3862 = var9;
               var11.field3861 = var10;
               continue;
            }

            throw new IllegalStateException();
         }

         this.method5309();
         return;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Llk;",
      garbageValue = "1678133732"
   )
   static IndexedSprite[] method5411() {
      IndexedSprite[] var0 = new IndexedSprite[class332.field3997];

      for(int var1 = 0; var1 < class332.field3997; ++var1) {
         IndexedSprite var2 = var0[var1] = new IndexedSprite();
         var2.width = class332.field3995;
         var2.originalHeight = class332.field3996;
         var2.offsetX = class90.field1360[var1];
         var2.offsetY = class153.offsetsY[var1];
         var2.originalWidth = class332.field3998[var1];
         var2.height = GrandExchangeOffer.field294[var1];
         var2.palette = class332.field3994;
         var2.pixels = ClassInfo.spritePixels[var1];
      }

      class316.method5605();
      return var0;
   }
}
