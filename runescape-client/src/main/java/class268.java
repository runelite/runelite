import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
public class class268 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   public static final class268 field3676;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   public static final class268 field3668;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   public static final class268 field3670;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   public static final class268 field3671;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   public static final class268 field3669;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   public static final class268 field3673;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field3674;
   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "[Lkb;"
   )
   @Export("headIconsHint")
   static SpritePixels[] headIconsHint;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -1398486691
   )
   static int field3677;
   @ObfuscatedName("u")
   final String field3672;
   @ObfuscatedName("t")
   String field3675;

   static {
      field3676 = new class268("PLAIN11", "p11_full");
      field3668 = new class268("PLAIN12", "p12_full");
      field3670 = new class268("BOLD12", "b12_full");
      field3671 = new class268("VERDANA11", "verdana_11pt_regular");
      field3669 = new class268("VERDANA13", "verdana_13pt_regular");
      field3673 = new class268("VERDANA15", "verdana_15pt_regular");
   }

   class268(String var1, String var2) {
      this.field3672 = var1;
      this.field3675 = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)[Lju;",
      garbageValue = "-374222925"
   )
   public static class268[] method4745() {
      return new class268[]{field3676, field3669, field3671, field3673, field3668, field3670};
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lij;III)[Lkb;",
      garbageValue = "2047586767"
   )
   static SpritePixels[] method4747(IndexDataBase var0, int var1, int var2) {
      if(!Sequence.method4738(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels[] var4 = new SpritePixels[class295.field3847];

         for(int var5 = 0; var5 < class295.field3847; ++var5) {
            SpritePixels var6 = var4[var5] = new SpritePixels();
            var6.maxWidth = class295.field3846;
            var6.maxHeight = class224.field2850;
            var6.offsetX = WidgetNode.field774[var5];
            var6.offsetY = class285.offsetsY[var5];
            var6.width = class295.field3848[var5];
            var6.height = class295.field3845[var5];
            int var7 = var6.width * var6.height;
            byte[] var8 = class70.spritePixels[var5];
            var6.pixels = new int[var7];

            for(int var9 = 0; var9 < var7; ++var9) {
               var6.pixels[var9] = class278.field3733[var8[var9] & 255];
            }
         }

         class274.method4876();
         return var4;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(CS)C",
      garbageValue = "25154"
   )
   static char method4746(char var0) {
      return var0 != 181 && var0 != 131?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgd;II)Z",
      garbageValue = "1660206876"
   )
   @Export("decodeRegionHash")
   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class94.field1405[++class94.field1407 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field834 = var1;
            if(class94.field1408[var1] != null) {
               var6.decodeApperance(class94.field1408[var1]);
            }

            var6.orientation = class94.field1395[var1];
            var6.interacting = class94.field1409[var1];
            var7 = class94.field1404[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field1189[0] = class94.field1398[var1];
            var6.field835 = (byte)var8;
            var6.method1068((var9 << 13) + var3 - class13.baseX, (var10 << 13) + var4 - ClanMember.baseY);
            var6.field818 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class94.field1404[var1];
         class94.field1404[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class94.field1404[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class94.field1404[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class94.field1404[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class94.field1404[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "20841"
   )
   public static void method4740() {
      try {
         if(class210.field2585 == 1) {
            int var0 = class210.field2587.method3740();
            if(var0 > 0 && class210.field2587.method3819()) {
               var0 -= FrameMap.field1952;
               if(var0 < 0) {
                  var0 = 0;
               }

               class210.field2587.method3845(var0);
               return;
            }

            class210.field2587.method3771();
            class210.field2587.method3802();
            if(class70.field802 != null) {
               class210.field2585 = 2;
            } else {
               class210.field2585 = 0;
            }

            class210.field2588 = null;
            class2.field12 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class210.field2587.method3771();
         class210.field2585 = 0;
         class210.field2588 = null;
         class2.field12 = null;
         class70.field802 = null;
      }

   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-237821335"
   )
   static final void method4744(String var0) {
      if(var0 != null) {
         String var1 = class226.method4078(var0, class189.field2529);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = class226.method4078(var4, class189.field2529);
               boolean var6;
               if(var0 != null && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.ignoreCount;

                  for(int var7 = var2; var7 < Client.ignoreCount; ++var7) {
                     Client.ignores[var7] = Client.ignores[var7 + 1];
                  }

                  Client.field1040 = Client.cycleCntr;
                  PacketNode var8 = class18.method133(ClientPacket.field2386, Client.field905.field1460);
                  var8.packetBuffer.putByte(class23.getLength(var0));
                  var8.packetBuffer.putString(var0);
                  Client.field905.method1855(var8);
                  break;
               }
            }

         }
      }
   }
}
