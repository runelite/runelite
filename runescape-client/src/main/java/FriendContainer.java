import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
@Implements("FriendContainer")
public class FriendContainer extends NameableContainer {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   final JagexLoginType field3656;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 325181365
   )
   int field3657;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public class208 field3658;

   @ObfuscatedSignature(
      signature = "(Lla;)V"
   )
   public FriendContainer(JagexLoginType var1) {
      super(400);
      this.field3657 = 1;
      this.field3658 = new class208();
      this.field3656 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Ljn;",
      garbageValue = "-39"
   )
   Nameable vmethod5491() {
      return new Friend();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[Ljn;",
      garbageValue = "-1283030275"
   )
   Nameable[] vmethod5492(int var1) {
      return new Friend[var1];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lkm;ZI)Z",
      garbageValue = "-939317206"
   )
   public boolean method5457(Name var1, boolean var2) {
      Friend var3 = (Friend)this.method5344(var1);
      return var3 == null?false:!var2 || var3.world != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)V",
      garbageValue = "-2"
   )
   public void method5449(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            boolean var3 = var1.readUnsignedByte() == 1;
            Name var4 = new Name(var1.readString(), this.field3656);
            Name var5 = new Name(var1.readString(), this.field3656);
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
               Friend var11 = (Friend)this.method5374(var4);
               if(var3) {
                  Friend var12 = (Friend)this.method5374(var5);
                  if(var12 != null && var11 != var12) {
                     if(var11 != null) {
                        this.method5362(var12);
                     } else {
                        var11 = var12;
                     }
                  }
               }

               if(var11 != null) {
                  this.method5339(var11, var4, var5);
                  if(var6 != var11.world) {
                     boolean var14 = true;

                     for(class294 var13 = (class294)this.field3658.method4147(); var13 != null; var13 = (class294)this.field3658.method4146()) {
                        if(var13.field3675.equals(var4)) {
                           if(var6 != 0 && var13.field3677 == 0) {
                              var13.method4156();
                              var14 = false;
                           } else if(var6 == 0 && var13.field3677 != 0) {
                              var13.method4156();
                              var14 = false;
                           }
                        }
                     }

                     if(var14) {
                        this.field3658.method4149(new class294(var4, var6));
                     }
                  }
               } else {
                  if(this.getCount() >= 400) {
                     continue;
                  }

                  var11 = (Friend)this.method5373(var4, var5);
               }

               if(var6 != var11.world) {
                  var11.field3649 = ++this.field3657 - 1;
                  if(var11.world == -1 && var6 == 0) {
                     var11.field3649 = -(var11.field3649 * 237190023) * -467035593;
                  }

                  var11.world = var6;
               }

               var11.rank = var7;
               var11.field3664 = var9;
               var11.field3663 = var10;
               continue;
            }

            throw new IllegalStateException();
         }

         this.method5383();
         return;
      }
   }
}
