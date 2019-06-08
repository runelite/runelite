import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
@Implements("FriendsList")
public class FriendsList extends UserList {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   @Export("loginType")
   final LoginType loginType;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -217526077
   )
   @Export("__x")
   int __x;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   @Export("friendLoginUpdates")
   public LinkDeque friendLoginUpdates;

   @ObfuscatedSignature(
      signature = "(Llx;)V"
   )
   public FriendsList(LoginType var1) {
      super(400);
      this.__x = 1;
      this.friendLoginUpdates = new LinkDeque();
      this.loginType = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Ljs;",
      garbageValue = "-2063112195"
   )
   User newInstance() {
      return new Friend();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)[Ljs;",
      garbageValue = "861814350"
   )
   User[] newTypedArray(int var1) {
      return new Friend[var1];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lkp;ZI)Z",
      garbageValue = "1557073132"
   )
   @Export("isFriended")
   public boolean isFriended(Username var1, boolean var2) {
      Friend var3 = (Friend)this.getByUsername(var1);
      return var3 != null && (!var2 || var3.world0 != 0);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgr;IB)V",
      garbageValue = "-11"
   )
   @Export("read")
   public void read(Buffer var1, int var2) {
      while(true) {
         if(var1.index < var2) {
            boolean var3 = var1.readUnsignedByte() == 1;
            Username var4 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
            Username var5 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
            int var6 = var1.__ag_302();
            int var7 = var1.readUnsignedByte();
            int var8 = var1.readUnsignedByte();
            boolean var9 = (var8 & 2) != 0;
            boolean var10 = (var8 & 1) != 0;
            if(var6 > 0) {
               var1.readStringCp1252NullTerminated();
               var1.readUnsignedByte();
               var1.readInt();
            }

            var1.readStringCp1252NullTerminated();
            if(var4 != null && var4.hasCleanName()) {
               Friend var11 = (Friend)this.getByCurrentUsername(var4);
               if(var3) {
                  Friend var12 = (Friend)this.getByCurrentUsername(var5);
                  if(var12 != null && var12 != var11) {
                     if(var11 != null) {
                        this.remove(var12);
                     } else {
                        var11 = var12;
                     }
                  }
               }

               if(var11 != null) {
                  this.changeName(var11, var4, var5);
                  if(var6 != var11.world0) {
                     boolean var14 = true;

                     for(FriendLoginUpdate var13 = (FriendLoginUpdate)this.friendLoginUpdates.__f_438(); var13 != null; var13 = (FriendLoginUpdate)this.friendLoginUpdates.__q_439()) {
                        if(var13.username.__equals_466(var4)) {
                           if(var6 != 0 && var13.world == 0) {
                              var13.remove();
                              var14 = false;
                           } else if(var6 == 0 && var13.world != 0) {
                              var13.remove();
                              var14 = false;
                           }
                        }
                     }

                     if(var14) {
                        this.friendLoginUpdates.__m_437(new FriendLoginUpdate(var4, var6));
                     }
                  }
               } else {
                  if(this.size() >= 400) {
                     continue;
                  }

                  var11 = (Friend)this.addLast(var4, var5);
               }

               if(var6 != var11.world0) {
                  var11.int2 = ++this.__x - 1;
                  if(var11.world0 == -1 && var6 == 0) {
                     var11.int2 = -(var11.int2 * -1377538447) * 120689297;
                  }

                  var11.world0 = var6;
               }

               var11.rank = var7;
               var11.__m = var9;
               var11.__f = var10;
               continue;
            }

            throw new IllegalStateException();
         }

         this.sort();
         return;
      }
   }
}
