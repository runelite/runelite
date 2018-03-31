import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kz")
public class class304 extends NameableContainer {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   static IndexedSprite field3848;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   final JagexLoginType field3845;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1990407931
   )
   int field3846;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   public class220 field3847;

   @ObfuscatedSignature(
      signature = "(Llo;)V"
   )
   public class304(JagexLoginType var1) {
      super(400);
      this.field3846 = 1;
      this.field3847 = new class220();
      this.field3845 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lku;",
      garbageValue = "437342171"
   )
   Nameable vmethod5462() {
      return new Friend();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[Lku;",
      garbageValue = "-1281183690"
   )
   Nameable[] vmethod5463(int var1) {
      return new Friend[var1];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lko;ZI)Z",
      garbageValue = "-695219581"
   )
   public boolean method5415(Name var1, boolean var2) {
      Friend var3 = (Friend)this.method5317(var1);
      return var3 == null?false:!var2 || var3.world != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "-1858683533"
   )
   public void method5420(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            boolean var3 = var1.readUnsignedByte() == 1;
            Name var4 = new Name(var1.readString(), this.field3845);
            Name var5 = new Name(var1.readString(), this.field3845);
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
            if(var4 != null && var4.method5450()) {
               Friend var11 = (Friend)this.method5319(var4);
               if(var3) {
                  Friend var12 = (Friend)this.method5319(var5);
                  if(var12 != null) {
                     if(var11 != null) {
                        this.method5321(var12);
                     } else {
                        var11 = var12;
                     }
                  }
               }

               if(var11 != null) {
                  this.method5326(var11, var4, var5);
                  if(var6 != var11.world) {
                     boolean var14 = true;

                     for(class308 var13 = (class308)this.field3847.method4061(); var13 != null; var13 = (class308)this.field3847.method4062()) {
                        if(var13.field3865.equals(var4)) {
                           if(var6 != 0 && var13.field3866 == 0) {
                              var13.method4069();
                              var14 = false;
                           } else if(var6 == 0 && var13.field3866 != 0) {
                              var13.method4069();
                              var14 = false;
                           }
                        }
                     }

                     if(var14) {
                        this.field3847.method4067(new class308(var4, var6));
                     }
                  }
               } else {
                  if(this.getCount() >= 400) {
                     continue;
                  }

                  var11 = (Friend)this.method5323(var4, var5);
               }

               if(var6 != var11.world) {
                  var11.field3839 = ++this.field3846 - 1;
                  if(var11.world == -1 && var6 == 0) {
                     var11.field3839 = -(var11.field3839 * 1320922141) * 806385205;
                  }

                  var11.world = var6;
               }

               var11.rank = var7;
               var11.field3854 = var9;
               var11.field3855 = var10;
               continue;
            }

            throw new IllegalStateException();
         }

         this.method5333();
         return;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BII)I",
      garbageValue = "1564177834"
   )
   public static int method5427(byte[] var0, int var1) {
      int var3 = -1;

      for(int var4 = 0; var4 < var1; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
