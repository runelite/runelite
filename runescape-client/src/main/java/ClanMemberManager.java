import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
@Implements("ClanMemberManager")
public class ClanMemberManager extends NameableContainer {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   final JagexLoginType field3668;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   final class288 field3666;
   @ObfuscatedName("a")
   public String field3667;
   @ObfuscatedName("l")
   public String field3669;
   @ObfuscatedName("d")
   public byte field3674;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -182421895
   )
   public int field3671;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1322445059
   )
   int field3672;

   @ObfuscatedSignature(
      signature = "(Lla;Lki;)V"
   )
   public ClanMemberManager(JagexLoginType var1, class288 var2) {
      super(100);
      this.field3667 = null;
      this.field3669 = null;
      this.field3672 = 1;
      this.field3668 = var1;
      this.field3666 = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Ljn;",
      garbageValue = "-39"
   )
   Nameable vmethod5491() {
      return new ClanMember();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[Ljn;",
      garbageValue = "-1283030275"
   )
   Nameable[] vmethod5492(int var1) {
      return new ClanMember[var1];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1529272657"
   )
   final void method5493(String var1) {
      long var5 = 0L;
      int var7 = var1.length();

      for(int var8 = 0; var8 < var7; ++var8) {
         var5 *= 37L;
         char var9 = var1.charAt(var8);
         if(var9 >= 'A' && var9 <= 'Z') {
            var5 += (long)(var9 + 1 - 65);
         } else if(var9 >= 'a' && var9 <= 'z') {
            var5 += (long)(var9 + 1 - 97);
         } else if(var9 >= '0' && var9 <= '9') {
            var5 += (long)(var9 + 27 - 48);
         }

         if(var5 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var5 % 37L && 0L != var5) {
         var5 /= 37L;
      }

      String var10 = class302.method5659(var5);
      if(var10 == null) {
         var10 = "";
      }

      this.field3667 = var10;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "128"
   )
   final void method5494(String var1) {
      long var5 = 0L;
      int var7 = var1.length();

      for(int var8 = 0; var8 < var7; ++var8) {
         var5 *= 37L;
         char var9 = var1.charAt(var8);
         if(var9 >= 'A' && var9 <= 'Z') {
            var5 += (long)(var9 + 1 - 65);
         } else if(var9 >= 'a' && var9 <= 'z') {
            var5 += (long)(var9 + 1 - 97);
         } else if(var9 >= '0' && var9 <= '9') {
            var5 += (long)(var9 + 27 - 48);
         }

         if(var5 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var5 % 37L && var5 != 0L) {
         var5 /= 37L;
      }

      String var10 = class302.method5659(var5);
      if(var10 == null) {
         var10 = "";
      }

      this.field3669 = var10;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1237689075"
   )
   public final void method5507(Buffer var1) {
      this.method5494(var1.readString());
      long var2 = var1.readLong();
      long var5 = var2;
      String var4;
      int var7;
      if(var2 > 0L && var2 < 6582952005840035281L) {
         if(0L == var2 % 37L) {
            var4 = null;
         } else {
            var7 = 0;

            for(long var13 = var2; var13 != 0L; var13 /= 37L) {
               ++var7;
            }

            StringBuilder var15 = new StringBuilder(var7);

            while(var5 != 0L) {
               long var11 = var5;
               var5 /= 37L;
               var15.append(class303.field3732[(int)(var11 - var5 * 37L)]);
            }

            var4 = var15.reverse().toString();
         }
      } else {
         var4 = null;
      }

      this.method5493(var4);
      this.field3674 = var1.readByte();
      var7 = var1.readUnsignedByte();
      if(var7 != 255) {
         this.method5340();

         for(int var8 = 0; var8 < var7; ++var8) {
            ClanMember var9 = (ClanMember)this.method5349(new Name(var1.readString(), this.field3668));
            int var10 = var1.readUnsignedShort();
            var9.method5432(var10, ++this.field3672 - 1);
            var9.rank = var1.readByte();
            var1.readString();
            this.method5499(var9);
         }

      }
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1624046819"
   )
   public final void method5496(Buffer var1) {
      Name var2 = new Name(var1.readString(), this.field3668);
      int var3 = var1.readUnsignedShort();
      byte var4 = var1.readByte();
      boolean var5 = false;
      if(var4 == -128) {
         var5 = true;
      }

      ClanMember var6;
      if(var5) {
         if(this.getCount() == 0) {
            return;
         }

         var6 = (ClanMember)this.method5374(var2);
         if(var6 != null && var6.method5433() == var3) {
            this.method5362(var6);
         }
      } else {
         var1.readString();
         var6 = (ClanMember)this.method5374(var2);
         if(var6 == null) {
            if(this.getCount() > super.field3642) {
               return;
            }

            var6 = (ClanMember)this.method5349(var2);
         }

         var6.method5432(var3, ++this.field3672 - 1);
         var6.rank = var4;
         this.method5499(var6);
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-265283783"
   )
   public final void method5518() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5275();
      }

   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public final void method5498() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5279();
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(Ljw;B)V",
      garbageValue = "18"
   )
   final void method5499(ClanMember var1) {
      if(var1.getRsName().equals(this.field3666.vmethod5443())) {
         this.field3671 = var1.rank;
      }

   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "-10"
   )
   static final void method5501(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class11.field82 || class54.field495 != var1) {
         class11.field82 = var0;
         class54.field495 = var1;
         Resampler.setGameState(25);
         class16.method187("Loading - please wait.", true);
         int var3 = class178.baseX;
         int var4 = CombatInfoListHolder.baseY;
         class178.baseX = (var0 - 6) * 8;
         CombatInfoListHolder.baseY = (var1 - 6) * 8;
         int var5 = class178.baseX - var3;
         int var6 = CombatInfoListHolder.baseY - var4;
         var3 = class178.baseX;
         var4 = CombatInfoListHolder.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < 32768; ++var7) {
            NPC var8 = Client.cachedNPCs[var7];
            if(var8 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var8.pathX[var9] -= var5;
                  var8.pathY[var9] -= var6;
               }

               var8.x -= var5 * 128;
               var8.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var21 = Client.cachedPlayers[var7];
            if(var21 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var21.pathX[var9] -= var5;
                  var21.pathY[var9] -= var6;
               }

               var21.x -= var5 * 128;
               var21.y -= var6 * 128;
            }
         }

         byte var20 = 0;
         byte var18 = 104;
         byte var22 = 1;
         if(var5 < 0) {
            var20 = 103;
            var18 = -1;
            var22 = -1;
         }

         byte var10 = 0;
         byte var11 = 104;
         byte var12 = 1;
         if(var6 < 0) {
            var10 = 103;
            var11 = -1;
            var12 = -1;
         }

         int var14;
         for(int var13 = var20; var18 != var13; var13 += var22) {
            for(var14 = var10; var14 != var11; var14 += var12) {
               int var15 = var13 + var5;
               int var16 = var14 + var6;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var13][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var13][var14] = null;
                  }
               }
            }
         }

         for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.getFront(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.getNext()) {
            var19.x -= var5;
            var19.y -= var6;
            if(var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
               var19.unlink();
            }
         }

         if(Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.queuedSoundEffectCount = 0;
         Client.field746 = false;
         WorldMapType3.cameraX -= var5 << 7;
         class13.cameraY -= var6 << 7;
         Signlink.field1979 -= var5 << 7;
         ItemContainer.field481 -= var6 << 7;
         Client.field815 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }
}
