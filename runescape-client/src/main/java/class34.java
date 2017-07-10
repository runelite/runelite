import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class34 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -37718825
   )
   int field485;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1821373383
   )
   int field486;
   @ObfuscatedName("r")
   class22 field487;
   @ObfuscatedName("v")
   LinkedList field488;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 465030449
   )
   int field489;
   @ObfuscatedName("e")
   SpritePixels field490;
   @ObfuscatedName("k")
   int[][] field491;
   @ObfuscatedName("o")
   List field492;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1335818319
   )
   int field493;
   @ObfuscatedName("l")
   final HashMap field494;
   @ObfuscatedName("c")
   static final Coordinates field496;
   @ObfuscatedName("z")
   HashMap field498;
   @ObfuscatedName("cq")
   static boolean field499;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = -506985325
   )
   static int field500;

   static {
      field496 = new Coordinates();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "1931846187"
   )
   void method352(HashSet var1, List var2) {
      this.field498.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method214() == this.field485 && var4.method215() == this.field486) {
            this.field488.add(var4);
            this.method353(var4.method658() * 8, var4.method659() * 8, 8, 8, var4);
         }
      }

      this.method354(var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIILclass28;I)V",
      garbageValue = "-880090423"
   )
   void method353(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label57:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field413; ++var9) {
               class31[] var10 = var5.field418[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method383(var13.field454);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field485 * 64 + var6, var7 + this.field486 * 64);
                        Coordinates var16 = null;
                        if(this.field487 != null) {
                           var16 = new Coordinates(this.field487.field412 + var9, this.field487.field420 * 64 + var6, this.field487.field409 * 64 + var7);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var17.field412 + var9, var17.field420 * 64 + var6 + var17.method656() * 8, var17.field409 * 64 + var7 + var17.method657() * 8);
                        }

                        class39 var18 = new class39(var14.field3297, var16, var15, this.method395(var14));
                        this.field498.put(var8, var18);
                        continue label57;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;S)V",
      garbageValue = "710"
   )
   void method354(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field371.worldX >> 6 == this.field485 && var3.field371.worldY >> 6 == this.field486) {
            class39 var4 = new class39(var3.field370, var3.field371, var3.field371, this.method384(var3.field370));
            this.field492.add(var4);
         }
      }

   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "28"
   )
   static void method356(int var0, int var1, int var2) {
      if(Client.field1165 != 0 && var1 != 0 && Client.field1181 < 50) {
         Client.field1168[Client.field1181] = var0;
         Client.field1169[Client.field1181] = var1;
         Client.field1170[Client.field1181] = var2;
         Client.audioEffects[Client.field1181] = null;
         Client.field1171[Client.field1181] = 0;
         ++Client.field1181;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILclass46;[Lclass34;[LModIcon;B)Z",
      garbageValue = "2"
   )
   boolean method357(int var1, class46 var2, class34[] var3, ModIcon[] var4) {
      if(!this.method358(var1)) {
         return false;
      } else if(this.field487 == null && this.field488.isEmpty()) {
         return false;
      } else {
         this.method364(var3);
         this.field490.method5059();
         if(this.field487 != null) {
            this.method359(var2, var3, var4);
         } else {
            this.method360(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2063733263"
   )
   boolean method358(int var1) {
      if(this.field490 != null && this.field493 == var1) {
         return false;
      } else {
         this.field493 = var1;
         this.field490 = new SpritePixels(this.field493 * 64, this.field493 * 64);
         return true;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass46;[Lclass34;[LModIcon;I)V",
      garbageValue = "-97260226"
   )
   void method359(class46 var1, class34[] var2, ModIcon[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method419(var4, var5, this.field487, var1);
            this.method428(var4, var5, this.field487, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method361(var4, var5, this.field487, var1, var3);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass46;[LModIcon;I)V",
      garbageValue = "-846251339"
   )
   void method360(class46 var1, ModIcon[] var2) {
      Iterator var3 = this.field488.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method658() * 8; var5 < var4.method658() * 8 + 8; ++var5) {
            for(var6 = var4.method659() * 8; var6 < var4.method659() * 8 + 8; ++var6) {
               this.method419(var5, var6, var4, var1);
               this.method428(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field488.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method658() * 8; var5 < var4.method658() * 8 + 8; ++var5) {
            for(var6 = var4.method659() * 8; var6 < var4.method659() * 8 + 8; ++var6) {
               this.method361(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;[LModIcon;I)V",
      garbageValue = "-1059050557"
   )
   void method361(int var1, int var2, class28 var3, class46 var4, ModIcon[] var5) {
      this.method497(var1, var2, var3);
      this.method464(var1, var2, var3, var5);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "2086761590"
   )
   void method362(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method388(var1, var2, var4, var3);
      this.method427(var1, var2, var4, var3);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([Lclass34;I)Z",
      garbageValue = "-1185037657"
   )
   boolean method364(class34[] var1) {
      if(this.field491 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field487 != null) {
            this.method367(0, 0, 64, 64, this.field487, var2);
         } else {
            Iterator var3 = this.field488.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method367(var4.method658() * 8, var4.method659() * 8, 8, 8, var4, var2);
            }
         }

         this.method392(var1, var2);
         this.method365(var2);
         return true;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass43;I)V",
      garbageValue = "1505120919"
   )
   void method365(class43 var1) {
      this.field491 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field491[var2][var3] = var1.method636(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "-77"
   )
   void method366(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field492.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = Area.field3303[var5.field548];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4289()))) {
            this.method374(var6, var5.field549, var5.field560, var2, var3);
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIILclass28;Lclass43;I)V",
      garbageValue = "-1866972271"
   )
   void method367(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field414[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class220.method4054(var9);
               var6.method635(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass34;Lclass43;I)V",
      garbageValue = "1218840884"
   )
   void method368(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method389(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class220.method4054(var11);
               var8.method635(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IILclass28;I)I",
      garbageValue = "971159512"
   )
   int method369(int var1, int var2, class28 var3) {
      return var3.field414[0][var1][var2] == 0?this.field489:this.field491[var1][var2];
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-768021458"
   )
   void method370(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method4943(this.field493 * var1, this.field493 * (63 - var2), this.field493, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method4941(this.field493 * var1, this.field493 * (63 - var2), this.field493, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method4943(this.field493 * var1 + this.field493 - 1, this.field493 * (63 - var2), this.field493, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method4941(this.field493 * var1, this.field493 + this.field493 * (63 - var2) - 1, this.field493, var4);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LArea;IIIII)V",
      garbageValue = "1259767235"
   )
   void method374(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4291(false);
      if(var6 != null) {
         var6.method5042(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method4930(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method4930(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIFI)V",
      garbageValue = "-2120002797"
   )
   void method375(class39 var1, int var2, int var3, float var4) {
      Area var5 = Area.field3303[var1.field548];
      this.method376(var5, var2, var3);
      this.method377(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(LArea;IIB)V",
      garbageValue = "-85"
   )
   void method376(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.method4291(false);
      if(var4 != null) {
         int var5 = this.method500(var4, var1.field3311);
         int var6 = this.method382(var4, var1.field3309);
         var4.method5042(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass39;LArea;IIFB)V",
      garbageValue = "2"
   )
   void method377(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field553 != null) {
         if(var1.field553.field478.method161(var5)) {
            Font var6 = (Font)this.field494.get(var1.field553.field478);
            var6.method4788(var1.field553.field476, var3 - var1.field553.field475 / 2, var4, var1.field553.field475, var1.field553.field477, -16777216 | var2.field3301, 0, 1, 0, var6.field3649 / 2);
         }
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-53411476"
   )
   void method379() {
      if(this.field487 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method487(var1, var2, this.field487);
            }
         }
      } else {
         Iterator var5 = this.field488.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method658() * 8; var3 < var6.method658() * 8 + 8; ++var3) {
               for(int var4 = var6.method659() * 8; var4 < var6.method659() * 8 + 8; ++var4) {
                  this.method487(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2136317673"
   )
   void method381(int var1, int var2, int var3) {
      if(this.field490 != null) {
         if(var3 == this.field493 * 64) {
            this.field490.method5074(var1, var2);
         } else {
            this.field490.method5066(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(LSpritePixels;Lclass239;I)I",
      garbageValue = "2121782342"
   )
   int method382(SpritePixels var1, class239 var2) {
      switch(var2.field3282) {
      case 0:
         return -var1.height / 2;
      case 1:
         return 0;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)LArea;",
      garbageValue = "-920466539"
   )
   Area method383(int var1) {
      ObjectComposition var2 = class251.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.field3303[var2.mapIconId]:null;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)Lclass33;",
      garbageValue = "-920491799"
   )
   class33 method384(int var1) {
      Area var2 = Area.field3303[var1];
      return this.method395(var2);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "1637669744"
   )
   List method386(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field498.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method551(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field492.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method551(var4, var5)) {
                  var6.add(var8);
               }
            }

            return var6;
         } else {
            return var6;
         }
      } else {
         return var6;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "2112137074"
   )
   List method387() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field492);
      var1.addAll(this.field498.values());
      return var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-833434089"
   )
   void method388(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field498.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var1 + var5 * (float)var9.worldX - var6);
         int var11 = (int)((float)(var2 + var4) - (float)var9.worldY * var5 - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field549 = var10;
            var12.field560 = var11;
            Area var13 = Area.field3303[var12.field548];
            if(!var3.contains(Integer.valueOf(var13.method4289()))) {
               this.method375(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-231143718"
   )
   int method389(int var1, int var2) {
      if(this.field487 != null) {
         return this.field487.method213(var1, var2);
      } else {
         if(!this.field488.isEmpty()) {
            Iterator var3 = this.field488.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method667(var1, var2)) {
                  return var4.method213(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([Lclass34;Lclass43;B)V",
      garbageValue = "50"
   )
   void method392(class34[] var1, class43 var2) {
      class228[] var3 = class182.method3431();
      class228[] var4 = var3;

      for(int var5 = 0; var5 < var4.length; ++var5) {
         class228 var6 = var4[var5];
         if(var1[var6.rsOrdinal()] != null) {
            byte var7 = 0;
            byte var8 = 0;
            byte var9 = 64;
            byte var10 = 64;
            byte var11 = 0;
            byte var12 = 0;
            switch(var6.field3167) {
            case 0:
               var8 = 59;
               var10 = 5;
               var11 = 59;
               var9 = 5;
               break;
            case 1:
               var12 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 2:
               var11 = 59;
               var9 = 5;
               break;
            case 3:
               var12 = 59;
               var10 = 5;
               break;
            case 4:
               var8 = 59;
               var10 = 5;
               break;
            case 5:
               var11 = 59;
               var12 = 59;
               var9 = 5;
               var10 = 5;
               break;
            case 6:
               var7 = 59;
               var9 = 5;
               break;
            case 7:
               var8 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
            }

            this.method368(var11, var12, var7, var8, var9, var10, var1[var6.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(LArea;B)Lclass33;",
      garbageValue = "-33"
   )
   class33 method395(Area var1) {
      if(var1.name != null && this.field494 != null && this.field494.get(class24.field364) != null) {
         int var3 = var1.field3302;
         class24[] var4 = new class24[]{class24.field364, class24.field358, class24.field359};
         class24[] var5 = var4;
         int var6 = 0;

         class24 var2;
         while(true) {
            if(var6 >= var5.length) {
               var2 = null;
               break;
            }

            class24 var7 = var5[var6];
            if(var3 == var7.field367) {
               var2 = var7;
               break;
            }

            ++var6;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.field494.get(var2);
            if(var14 == null) {
               return null;
            } else {
               var6 = var14.method4752(var1.name, 1000000);
               String[] var15 = new String[var6];
               var14.method4750(var1.name, (int[])null, var15);
               int var8 = var14.field3649 * var15.length / 2;
               int var9 = 0;
               String[] var10 = var15;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.method4773(var12);
                  if(var13 > var9) {
                     var9 = var13;
                  }
               }

               return new class33(var1.name, var9, var8, var2);
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;I)V",
      garbageValue = "2096894289"
   )
   void method419(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field414[0][var1][var2] - 1;
      int var6 = var3.field421[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method4983(this.field493 * var1, this.field493 * (63 - var2), this.field493, this.field493, this.field489);
      }

      int var7 = 16711935;
      int var8;
      if(var6 != -1) {
         int var9 = this.field489;
         Overlay var10 = NPC.method1706(var6);
         if(var10 == null) {
            var8 = var9;
         } else if(var10.field3601 >= 0) {
            var8 = var10.field3601 | -16777216;
         } else if(var10.texture >= 0) {
            int var11 = ChatLineBuffer.method1877(class136.field2028.vmethod2876(var10.texture), 96);
            var8 = class136.colorPalette[var11] | -16777216;
         } else if(var10.color == 16711935) {
            var8 = var9;
         } else {
            int var12 = var10.hue;
            int var13 = var10.saturation;
            int var14 = var10.lightness;
            if(var14 > 179) {
               var13 /= 2;
            }

            if(var14 > 192) {
               var13 /= 2;
            }

            if(var14 > 217) {
               var13 /= 2;
            }

            if(var14 > 243) {
               var13 /= 2;
            }

            int var15 = var14 / 2 + (var12 / 4 << 10) + (var13 / 32 << 7);
            int var16 = ChatLineBuffer.method1877(var15, 96);
            var8 = class136.colorPalette[var16] | -16777216;
         }

         var7 = var8;
      }

      if(var6 > -1 && var3.field408[0][var1][var2] == 0) {
         Rasterizer2D.method4983(this.field493 * var1, this.field493 * (63 - var2), this.field493, this.field493, var7);
      } else {
         var8 = this.method369(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method4983(this.field493 * var1, this.field493 * (63 - var2), this.field493, this.field493, var8);
         } else {
            var4.method685(this.field493 * var1, this.field493 * (63 - var2), var8, var7, this.field493, this.field493, var3.field408[0][var1][var2], var3.field419[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "656117249"
   )
   void method427(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field492.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field550.worldX % 64;
         int var9 = var7.field550.worldY % 64;
         var7.field549 = (int)((float)var8 * var5 + (float)var1);
         var7.field560 = (int)(var5 * (float)(63 - var9) + (float)var2);
         if(!var3.contains(Integer.valueOf(var7.field548))) {
            this.method375(var7, var7.field549, var7.field560, var5);
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;I)V",
      garbageValue = "-1614168608"
   )
   void method428(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field413; ++var5) {
         int var6 = var3.field421[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var8 = this.field489;
            Overlay var9 = NPC.method1706(var6);
            int var7;
            if(var9 == null) {
               var7 = var8;
            } else if(var9.field3601 >= 0) {
               var7 = var9.field3601 | -16777216;
            } else if(var9.texture >= 0) {
               int var10 = ChatLineBuffer.method1877(class136.field2028.vmethod2876(var9.texture), 96);
               var7 = class136.colorPalette[var10] | -16777216;
            } else if(var9.color == 16711935) {
               var7 = var8;
            } else {
               int var11 = var9.hue;
               int var12 = var9.saturation;
               int var13 = var9.lightness;
               if(var13 > 179) {
                  var12 /= 2;
               }

               if(var13 > 192) {
                  var12 /= 2;
               }

               if(var13 > 217) {
                  var12 /= 2;
               }

               if(var13 > 243) {
                  var12 /= 2;
               }

               int var14 = var13 / 2 + (var12 / 32 << 7) + (var11 / 4 << 10);
               int var15 = ChatLineBuffer.method1877(var14, 96);
               var7 = class136.colorPalette[var15] | -16777216;
            }

            if(var3.field408[var5][var1][var2] == 0) {
               Rasterizer2D.method4983(this.field493 * var1, this.field493 * (63 - var2), this.field493, this.field493, var7);
            } else {
               var4.method685(this.field493 * var1, this.field493 * (63 - var2), 0, var7, this.field493, this.field493, var3.field408[var5][var1][var2], var3.field419[var5][var1][var2]);
            }
         }
      }

   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field485 = var1;
      this.field486 = var2;
      this.field488 = new LinkedList();
      this.field492 = new LinkedList();
      this.field498 = new HashMap();
      this.field489 = var3 | -16777216;
      this.field494 = var4;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "621454679"
   )
   void method463(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field498.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field548))) {
            Area var6 = Area.field3303[var5.field548];
            this.method374(var6, var5.field549, var5.field560, var2, var3);
         }
      }

      this.method366(var1, var2, var3);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILclass28;[LModIcon;I)V",
      garbageValue = "-941487097"
   )
   void method464(int var1, int var2, class28 var3, ModIcon[] var4) {
      for(int var5 = 0; var5 < var3.field413; ++var5) {
         class31[] var6 = var3.field418[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               if(class203.method3665(var9.field453) || class204.method3743(var9.field453)) {
                  ObjectComposition var10 = class251.getObjectDefinition(var9.field454);
                  if(var10.mapSceneId != -1) {
                     if(var10.mapSceneId != 46 && var10.mapSceneId != 52) {
                        var4[var10.mapSceneId].method5028(this.field493 * var1, this.field493 * (63 - var2), this.field493 * 2, this.field493 * 2);
                     } else {
                        var4[var10.mapSceneId].method5028(this.field493 * var1, this.field493 * (63 - var2), this.field493 * 2 + 1, this.field493 * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IILclass28;I)V",
      garbageValue = "2007163600"
   )
   void method487(int var1, int var2, class28 var3) {
      field496.method3912(0, var1, var2);

      for(int var4 = 0; var4 < var3.field413; ++var4) {
         class31[] var5 = var3.field418[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method383(var8.field454);
               if(var9 != null) {
                  class39 var10 = (class39)this.field498.get(field496);
                  if(var10 != null) {
                     if(var9.field3297 != var10.field548) {
                        class39 var16 = new class39(var9.field3297, var10.field547, var10.field550, this.method395(var9));
                        this.field498.put(new Coordinates(field496), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field547.plane - var10.field550.plane;
                     var10.field550.plane = var4;
                     var10.field547.plane = var15 + var4;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field485 * 64 + var1, var2 + this.field486 * 64);
                  Coordinates var12 = null;
                  if(this.field487 != null) {
                     var12 = new Coordinates(this.field487.field412 + var4, this.field487.field420 * 64 + var1, this.field487.field409 * 64 + var2);
                  } else {
                     Iterator var13 = this.field488.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method667(var1, var2)) {
                           var12 = new Coordinates(var14.field412 + var4, var14.field420 * 64 + var1 + var14.method656() * 8, var2 + var14.field409 * 64 + var14.method657() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3297, var12, var11, this.method395(var9));
                     this.field498.put(new Coordinates(field496), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field498.remove(field496);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IILclass28;I)V",
      garbageValue = "2079364467"
   )
   void method497(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field413; ++var4) {
         class31[] var5 = var3.field418[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               if(class31.method268(var8.field453)) {
                  ObjectComposition var9 = class251.getObjectDefinition(var8.field454);
                  int var10 = var9.field3488 != 0?-3407872:-3355444;
                  if(var8.field453 == class221.field2828.field2842) {
                     this.method370(var1, var2, var8.field455, var10);
                  }

                  if(var8.field453 == class221.field2821.field2842) {
                     this.method370(var1, var2, var8.field455, -3355444);
                     this.method370(var1, var2, var8.field455 + 1, var10);
                  }

                  if(var8.field453 == class221.field2822.field2842) {
                     if(var8.field455 == 0) {
                        Rasterizer2D.method4941(this.field493 * var1, this.field493 * (63 - var2), 1, var10);
                     }

                     if(var8.field455 == 1) {
                        Rasterizer2D.method4941(var1 * this.field493 + this.field493 - 1, this.field493 * (63 - var2), 1, var10);
                     }

                     if(var8.field455 == 2) {
                        Rasterizer2D.method4941(var1 * this.field493 + this.field493 - 1, this.field493 + this.field493 * (63 - var2) - 1, 1, var10);
                     }

                     if(var8.field455 == 3) {
                        Rasterizer2D.method4941(this.field493 * var1, this.field493 + this.field493 * (63 - var2) - 1, 1, var10);
                     }
                  }

                  if(var8.field453 == class221.field2823.field2842) {
                     int var11 = var8.field455 % 2;
                     int var12;
                     if(var11 == 0) {
                        for(var12 = 0; var12 < this.field493; ++var12) {
                           Rasterizer2D.method4941(this.field493 * var1 + var12, (64 - var2) * this.field493 - 1 - var12, 1, var10);
                        }
                     } else {
                        for(var12 = 0; var12 < this.field493; ++var12) {
                           Rasterizer2D.method4941(this.field493 * var1 + var12, this.field493 * (63 - var2) + var12, 1, var10);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(LSpritePixels;Lclass257;B)I",
      garbageValue = "42"
   )
   int method500(SpritePixels var1, class257 var2) {
      switch(var2.field3550) {
      case 1:
         return -var1.width / 2;
      case 2:
         return 0;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass22;Ljava/util/List;I)V",
      garbageValue = "1039382218"
   )
   void method503(class22 var1, List var2) {
      this.field498.clear();
      this.field487 = var1;
      this.method353(0, 0, 64, 64, this.field487);
      this.method354(var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;IS)V",
      garbageValue = "1407"
   )
   static void method505(PacketBuffer var0, int var1) {
      boolean var2 = var0.method3388(1) == 1;
      if(var2) {
         class96.field1529[++class96.field1525 - 1] = var1;
      }

      int var3 = var0.method3388(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field913 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class96.field1522[var1] = (var4.pathY[0] + class266.baseY >> 13) + (var4.pathX[0] + class50.baseX >> 13 << 14) + (var4.field911 << 28);
            if(var4.field1266 != -1) {
               class96.field1526[var1] = var4.field1266;
            } else {
               class96.field1526[var1] = var4.orientation;
            }

            class96.field1527[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method3388(1) != 0) {
               class149.method2899(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method3388(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1176(var6, var7);
               var4.field913 = false;
            } else if(var2) {
               var4.field913 = true;
               var4.field917 = var6;
               var4.field915 = var7;
            } else {
               var4.field913 = false;
               var4.method1158(var6, var7, class96.field1519[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method3388(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1176(var6, var7);
               var4.field913 = false;
            } else if(var2) {
               var4.field913 = true;
               var4.field917 = var6;
               var4.field915 = var7;
            } else {
               var4.field913 = false;
               var4.method1158(var6, var7, class96.field1519[var1]);
            }

         } else {
            var5 = var0.method3388(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method3388(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var4.pathY[0] + var9;
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1176(var10, var11);
                  var4.field913 = false;
               } else if(var2) {
                  var4.field913 = true;
                  var4.field917 = var10;
                  var4.field915 = var11;
               } else {
                  var4.field913 = false;
                  var4.method1158(var10, var11, class96.field1519[var1]);
               }

               var4.field911 = (byte)(var4.field911 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  WallObject.plane = var4.field911;
               }

            } else {
               var6 = var0.method3388(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + var4.pathX[0] + class50.baseX & 16383) - class50.baseX;
               var11 = (var9 + var4.pathY[0] + class266.baseY & 16383) - class266.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field913 = true;
                     var4.field917 = var10;
                     var4.field915 = var11;
                  } else {
                     var4.field913 = false;
                     var4.method1158(var10, var11, class96.field1519[var1]);
                  }
               } else {
                  var4.method1176(var10, var11);
                  var4.field913 = false;
               }

               var4.field911 = (byte)(var4.field911 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  WallObject.plane = var4.field911;
               }

            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1105470431"
   )
   static void method506() {
      class61.field770 = 99;
      class61.underlayIds = new byte[4][104][104];
      class61.overlayIds = new byte[4][104][104];
      class36.overlayPaths = new byte[4][104][104];
      class67.overlayRotations = new byte[4][104][104];
      class39.field555 = new int[4][105][105];
      class61.field771 = new byte[4][105][105];
      class61.field774 = new int[105][105];
      class17.field316 = new int[104];
      class230.field3190 = new int[104];
      class10.field258 = new int[104];
      class158.field2273 = new int[104];
      Buffer.field2406 = new int[104];
   }
}
