import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ky")
public class class304 extends NameableContainer {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   final JagexLoginType field3860;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -55642671
   )
   int field3862;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   public class220 field3864;

   @ObfuscatedSignature(
      signature = "(Lly;)V"
   )
   public class304(JagexLoginType var1) {
      super(400);
      this.field3862 = 1;
      this.field3864 = new class220();
      this.field3860 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lkg;",
      garbageValue = "1778408778"
   )
   Nameable vmethod5513() {
      return new Friend();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)[Lkg;",
      garbageValue = "0"
   )
   Nameable[] vmethod5514(int var1) {
      return new Friend[var1];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lkb;ZS)Z",
      garbageValue = "3311"
   )
   public boolean method5472(Name var1, boolean var2) {
      Friend var3 = (Friend)this.method5367(var1);
      return var3 == null?false:!var2 || var3.world != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgg;II)V",
      garbageValue = "-245634554"
   )
   public void method5473(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            boolean var3 = var1.readUnsignedByte() == 1;
            Name var4 = new Name(var1.readString(), this.field3860);
            Name var5 = new Name(var1.readString(), this.field3860);
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
            if(var4 != null && var4.isCleanNameValid()) {
               Friend var11 = (Friend)this.method5368(var4);
               if(var3) {
                  Friend var12 = (Friend)this.method5368(var5);
                  if(var12 != null && var12 != var11) {
                     if(var11 != null) {
                        this.method5415(var12);
                     } else {
                        var11 = var12;
                     }
                  }
               }

               if(var11 != null) {
                  this.method5375(var11, var4, var5);
                  if(var6 != var11.world) {
                     boolean var14 = true;

                     for(class308 var13 = (class308)this.field3864.method4154(); var13 != null; var13 = (class308)this.field3864.method4152()) {
                        if(var13.field3878.equals(var4)) {
                           if(var6 != 0 && var13.field3879 == 0) {
                              var13.method4165();
                              var14 = false;
                           } else if(var6 == 0 && var13.field3879 != 0) {
                              var13.method4165();
                              var14 = false;
                           }
                        }
                     }

                     if(var14) {
                        this.field3864.method4153(new class308(var4, var6));
                     }
                  }
               } else {
                  if(this.getCount() >= 400) {
                     continue;
                  }

                  var11 = (Friend)this.method5372(var4, var5);
               }

               if(var6 != var11.world) {
                  var11.field3851 = ++this.field3862 - 1;
                  if(var11.world == -1 && var6 == 0) {
                     var11.field3851 = -(var11.field3851 * 1925630229) * -671924675;
                  }

                  var11.world = var6;
               }

               var11.rank = var7;
               var11.field3867 = var9;
               var11.field3868 = var10;
               continue;
            }

            throw new IllegalStateException();
         }

         this.method5362();
         return;
      }
   }
}
