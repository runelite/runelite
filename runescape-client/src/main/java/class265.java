import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
public class class265 extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   public static IndexDataBase field3497;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   public static IndexDataBase field3487;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   public static IndexDataBase field3488;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   public static NodeCache field3499;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   public static NodeCache field3489;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   public static NodeCache field3491;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -97654039
   )
   int field3504;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 386521733
   )
   public int field3492;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1209249643
   )
   public int field3500;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 410186867
   )
   int field3495;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 359652631
   )
   int field3490;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1878079493
   )
   int field3493;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1695900821
   )
   int field3498;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -637046979
   )
   public int field3486;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -699244893
   )
   public int field3496;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1815337345
   )
   public int field3501;
   @ObfuscatedName("b")
   String field3502;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2139281617
   )
   public int field3503;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1335440937
   )
   public int field3494;
   @ObfuscatedName("v")
   public int[] field3505;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -793379167
   )
   int field3506;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 572235537
   )
   int field3507;

   static {
      field3499 = new NodeCache(64);
      field3489 = new NodeCache(64);
      field3491 = new NodeCache(20);
   }

   class265() {
      this.field3504 = -1;
      this.field3492 = 16777215;
      this.field3500 = 70;
      this.field3495 = -1;
      this.field3490 = -1;
      this.field3493 = -1;
      this.field3498 = -1;
      this.field3486 = 0;
      this.field3496 = 0;
      this.field3501 = -1;
      this.field3502 = "";
      this.field3503 = -1;
      this.field3494 = 0;
      this.field3506 = -1;
      this.field3507 = -1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgh;S)V",
      garbageValue = "3472"
   )
   void method4623(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4624(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgh;IB)V",
      garbageValue = "-1"
   )
   void method4624(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3504 = var1.method3372();
      } else if(var2 == 2) {
         this.field3492 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3495 = var1.method3372();
      } else if(var2 == 4) {
         this.field3493 = var1.method3372();
      } else if(var2 == 5) {
         this.field3490 = var1.method3372();
      } else if(var2 == 6) {
         this.field3498 = var1.method3372();
      } else if(var2 == 7) {
         this.field3486 = var1.readShort();
      } else if(var2 == 8) {
         this.field3502 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3500 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3496 = var1.readShort();
      } else if(var2 == 11) {
         this.field3501 = 0;
      } else if(var2 == 12) {
         this.field3503 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3494 = var1.readShort();
      } else if(var2 == 14) {
         this.field3501 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3506 = var1.readUnsignedShort();
         if(this.field3506 == 65535) {
            this.field3506 = -1;
         }

         this.field3507 = var1.readUnsignedShort();
         if(this.field3507 == 65535) {
            this.field3507 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3505 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3505[var5] = var1.readUnsignedShort();
            if(this.field3505[var5] == 65535) {
               this.field3505[var5] = -1;
            }
         }

         this.field3505[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Lje;",
      garbageValue = "688727945"
   )
   public final class265 method4625() {
      int var1 = -1;
      if(this.field3506 != -1) {
         var1 = class36.getVarbit(this.field3506);
      } else if(this.field3507 != -1) {
         var1 = class222.widgetSettings[this.field3507];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3505.length - 1) {
         var2 = this.field3505[var1];
      } else {
         var2 = this.field3505[this.field3505.length - 1];
      }

      return var2 != -1?IndexData.method4378(var2):null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1103143413"
   )
   public String method4626(int var1) {
      String var2 = this.field3502;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         String var4 = var2.substring(0, var3);
         String var5 = Integer.toString(var1);
         var2 = var4 + var5 + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Lks;",
      garbageValue = "91"
   )
   public SpritePixels method4627() {
      if(this.field3495 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3489.get((long)this.field3495);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SocketSession.takeItemSnapshot(field3487, this.field3495, 0);
            if(var1 != null) {
               field3489.put(var1, (long)this.field3495);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lks;",
      garbageValue = "1002412837"
   )
   public SpritePixels method4628() {
      if(this.field3490 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3489.get((long)this.field3490);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SocketSession.takeItemSnapshot(field3487, this.field3490, 0);
            if(var1 != null) {
               field3489.put(var1, (long)this.field3490);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Lks;",
      garbageValue = "86279946"
   )
   public SpritePixels method4644() {
      if(this.field3493 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3489.get((long)this.field3493);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SocketSession.takeItemSnapshot(field3487, this.field3493, 0);
            if(var1 != null) {
               field3489.put(var1, (long)this.field3493);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lks;",
      garbageValue = "-235496103"
   )
   public SpritePixels method4629() {
      if(this.field3498 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3489.get((long)this.field3498);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SocketSession.takeItemSnapshot(field3487, this.field3498, 0);
            if(var1 != null) {
               field3489.put(var1, (long)this.field3498);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Ljm;",
      garbageValue = "26"
   )
   public Font method4631() {
      if(this.field3504 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3491.get((long)this.field3504);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var3 = field3487;
            IndexDataBase var4 = field3488;
            int var5 = this.field3504;
            Font var2;
            if(!Parameters.spriteDataValid(var3, var5, 0)) {
               var2 = null;
            } else {
               byte[] var7 = var4.getConfigData(var5, 0);
               Font var6;
               if(var7 == null) {
                  var6 = null;
               } else {
                  Font var8 = new Font(var7, class299.field3867, class299.offsetsY, Item.field1387, class276.field3727, FaceNormal.field2025, Bounds.spritePixels);
                  ContextMenuRow.resetCachedStaticSpriteData();
                  var6 = var8;
               }

               var2 = var6;
            }

            if(var2 != null) {
               field3491.put(var2, (long)this.field3504);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "50"
   )
   public static String method4657(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 'A' && var7 <= 'Z') {
            var3 += (long)(var7 + 1 - 65);
         } else if(var7 >= 'a' && var7 <= 'z') {
            var3 += (long)(var7 + 1 - 97);
         } else if(var7 >= '0' && var7 <= '9') {
            var3 += (long)(var7 + 27 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(var3 % 37L == 0L && 0L != var3) {
         var3 /= 37L;
      }

      String var8 = class96.method1808(var3);
      if(var8 == null) {
         var8 = "";
      }

      return var8;
   }
}
