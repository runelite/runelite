import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
public class class265 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   public static IndexDataBase field3515;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   public static IndexDataBase field3498;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static NodeCache field3506;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static NodeCache field3500;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static NodeCache field3501;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2070403729
   )
   int field3504;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1031355717
   )
   public int field3509;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -868034199
   )
   public int field3503;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2056784915
   )
   int field3505;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -138609915
   )
   int field3508;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1489037751
   )
   int field3497;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -398279087
   )
   int field3510;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 707395385
   )
   public int field3511;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1427425219
   )
   public int field3499;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1980964453
   )
   public int field3513;
   @ObfuscatedName("j")
   String field3514;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 476137523
   )
   public int field3512;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 202136007
   )
   public int field3516;
   @ObfuscatedName("k")
   public int[] field3507;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1243112965
   )
   int field3518;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -384851109
   )
   int field3519;

   static {
      field3506 = new NodeCache(64);
      field3500 = new NodeCache(64);
      field3501 = new NodeCache(20);
   }

   class265() {
      this.field3504 = -1;
      this.field3509 = 16777215;
      this.field3503 = 70;
      this.field3505 = -1;
      this.field3508 = -1;
      this.field3497 = -1;
      this.field3510 = -1;
      this.field3511 = 0;
      this.field3499 = 0;
      this.field3513 = -1;
      this.field3514 = "";
      this.field3512 = -1;
      this.field3516 = 0;
      this.field3518 = -1;
      this.field3519 = -1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "-916015100"
   )
   void method4673(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4674(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgv;IS)V",
      garbageValue = "400"
   )
   void method4674(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3504 = var1.method3514();
      } else if(var2 == 2) {
         this.field3509 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3505 = var1.method3514();
      } else if(var2 == 4) {
         this.field3497 = var1.method3514();
      } else if(var2 == 5) {
         this.field3508 = var1.method3514();
      } else if(var2 == 6) {
         this.field3510 = var1.method3514();
      } else if(var2 == 7) {
         this.field3511 = var1.readShort();
      } else if(var2 == 8) {
         this.field3514 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3503 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3499 = var1.readShort();
      } else if(var2 == 11) {
         this.field3513 = 0;
      } else if(var2 == 12) {
         this.field3512 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3516 = var1.readShort();
      } else if(var2 == 14) {
         this.field3513 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3518 = var1.readUnsignedShort();
         if(this.field3518 == 65535) {
            this.field3518 = -1;
         }

         this.field3519 = var1.readUnsignedShort();
         if(this.field3519 == 65535) {
            this.field3519 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3507 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3507[var5] = var1.readUnsignedShort();
            if(this.field3507[var5] == 65535) {
               this.field3507[var5] = -1;
            }
         }

         this.field3507[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)Ljd;",
      garbageValue = "11676"
   )
   public final class265 method4682() {
      int var1 = -1;
      if(this.field3518 != -1) {
         var1 = PendingSpawn.getVarbit(this.field3518);
      } else if(this.field3519 != -1) {
         var1 = class222.widgetSettings[this.field3519];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3507.length - 1) {
         var2 = this.field3507[var1];
      } else {
         var2 = this.field3507[this.field3507.length - 1];
      }

      return var2 != -1?PacketNode.method3257(var2):null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-82"
   )
   public String method4676(int var1) {
      String var2 = this.field3514;

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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Lkg;",
      garbageValue = "4"
   )
   public SpritePixels method4677() {
      if(this.field3505 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3500.get((long)this.field3505);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameCanvas.method772(class60.field725, this.field3505, 0);
            if(var1 != null) {
               field3500.put(var1, (long)this.field3505);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)Lkg;",
      garbageValue = "1170"
   )
   public SpritePixels method4678() {
      if(this.field3508 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3500.get((long)this.field3508);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameCanvas.method772(class60.field725, this.field3508, 0);
            if(var1 != null) {
               field3500.put(var1, (long)this.field3508);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lkg;",
      garbageValue = "74221859"
   )
   public SpritePixels method4700() {
      if(this.field3497 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3500.get((long)this.field3497);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameCanvas.method772(class60.field725, this.field3497, 0);
            if(var1 != null) {
               field3500.put(var1, (long)this.field3497);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lkg;",
      garbageValue = "482337760"
   )
   public SpritePixels method4680() {
      if(this.field3510 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3500.get((long)this.field3510);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameCanvas.method772(class60.field725, this.field3510, 0);
            if(var1 != null) {
               field3500.put(var1, (long)this.field3510);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)Ljz;",
      garbageValue = "109"
   )
   public Font method4699() {
      if(this.field3504 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3501.get((long)this.field3504);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var3 = class60.field725;
            IndexDataBase var4 = field3498;
            int var5 = this.field3504;
            Font var2;
            if(!class288.method5126(var3, var5, 0)) {
               var2 = null;
            } else {
               byte[] var7 = var4.getConfigData(var5, 0);
               Font var6;
               if(var7 == null) {
                  var6 = null;
               } else {
                  Font var8 = new Font(var7, class299.field3870, class299.offsetsY, class54.field635, UrlRequester.field2099, class299.field3869, class188.spritePixels);
                  class139.method2922();
                  var6 = var8;
               }

               var2 = var6;
            }

            if(var2 != null) {
               field3501.put(var2, (long)this.field3504);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1294944634"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + PacketBuffer.charToByteCp1252(var0.charAt(var3));
      }

      return var2;
   }
}
