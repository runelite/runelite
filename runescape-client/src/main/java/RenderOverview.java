import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   @Export("fontNameVerdana11")
   static final FontName fontNameVerdana11;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   @Export("fontNameVerdana13")
   static final FontName fontNameVerdana13;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   @Export("fontNameVerdana15")
   static final FontName fontNameVerdana15;
   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   @Export("headIconsHint")
   static SpritePixels[] headIconsHint;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   IndexDataBase field3885;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   Font field3926;
   @ObfuscatedName("c")
   HashMap field3882;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   IndexedSprite[] field3891;
   @ObfuscatedName("n")
   HashMap field3898;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   WorldMapData field3893;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   WorldMapData field3884;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   WorldMapData field3902;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   class41 field3899;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lkc;"
   )
   class300 field3897;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1433732217
   )
   int field3921;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1079914663
   )
   int field3886;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1994284873
   )
   int field3900;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 328852937
   )
   int field3901;
   @ObfuscatedName("d")
   float field3912;
   @ObfuscatedName("v")
   float field3903;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2093152855
   )
   int field3894;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -820698939
   )
   int field3905;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 947917663
   )
   int field3925;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -655933247
   )
   int field3907;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -845290703
   )
   int field3908;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1327978797
   )
   int field3909;
   @ObfuscatedName("aq")
   boolean field3910;
   @ObfuscatedName("ax")
   HashSet field3911;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1426675251
   )
   int field3904;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 656090803
   )
   int field3913;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 766134945
   )
   int field3914;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1745312795
   )
   int field3915;
   @ObfuscatedName("aw")
   HashSet field3916;
   @ObfuscatedName("al")
   HashSet field3917;
   @ObfuscatedName("ay")
   HashSet field3918;
   @ObfuscatedName("ai")
   HashSet field3919;
   @ObfuscatedName("af")
   boolean field3920;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 798940403
   )
   int field3880;
   @ObfuscatedName("av")
   final int[] field3896;
   @ObfuscatedName("ae")
   List field3923;
   @ObfuscatedName("am")
   Iterator field3879;
   @ObfuscatedName("aa")
   HashSet field3892;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   Coordinates field3906;

   static {
      fontNameVerdana11 = FontName.field3688;
      fontNameVerdana13 = FontName.field3697;
      fontNameVerdana15 = FontName.field3692;
   }

   public RenderOverview() {
      this.field3900 = -1;
      this.field3901 = -1;
      this.field3894 = -1;
      this.field3905 = -1;
      this.field3925 = -1;
      this.field3907 = -1;
      this.field3908 = 3;
      this.field3909 = 50;
      this.field3910 = false;
      this.field3911 = null;
      this.field3904 = -1;
      this.field3913 = -1;
      this.field3914 = -1;
      this.field3915 = -1;
      this.field3916 = new HashSet();
      this.field3917 = new HashSet();
      this.field3918 = new HashSet();
      this.field3919 = new HashSet();
      this.field3920 = false;
      this.field3880 = 0;
      this.field3896 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3892 = new HashSet();
      this.field3906 = null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;Ljm;Ljava/util/HashMap;[Lkg;I)V",
      garbageValue = "755880021"
   )
   public void method5340(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field3891 = var4;
      this.field3885 = var1;
      this.field3926 = var2;
      this.field3882 = new HashMap();
      this.field3882.put(Size.field335, var3.get(fontNameVerdana11));
      this.field3882.put(Size.field333, var3.get(fontNameVerdana13));
      this.field3882.put(Size.field334, var3.get(fontNameVerdana15));
      this.field3897 = new class300(var1);
      int var5 = this.field3885.getFile(class40.field510.field514);
      int[] var6 = this.field3885.getChilds(var5);
      this.field3898 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3885.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3898.put(var9.method330(), var9);
         if(var9.method337()) {
            this.field3893 = var9;
         }
      }

      this.method5353(this.field3893);
      this.field3902 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1934665663"
   )
   public int method5421() {
      return this.field3885.tryLoadRecordByNames(this.field3893.method330(), class40.field511.field514)?100:this.field3885.archiveLoadPercentByName(this.field3893.method330());
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "2144202242"
   )
   public void method5342(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3897.method5337()) {
         this.method5345();
         this.method5515();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3912));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3912));
            List var10 = this.field3899.method557(this.field3921 - var8 / 2 - 1, this.field3886 - var9 / 2 - 1, var8 / 2 + this.field3921 + 1, var9 / 2 + this.field3886 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); CacheFile.method2350(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field499, var13.field504, var13.field498);
               var14.method1050(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3892.contains(var13)) {
                  var14.method1051(class230.field2896);
               } else {
                  var14.method1051(class230.field2901);
               }
            }

            var12 = this.field3892.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field499, var13.field504, var13.field498);
                  var14.method1050(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1051(class230.field2902);
                  CacheFile.method2350(var14);
               }
            }

            this.field3892 = var11;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIZZI)V",
      garbageValue = "1314476423"
   )
   public void method5343(int var1, int var2, boolean var3, boolean var4) {
      this.method5372(var1, var2, var4);
      if(this.field3914 == -1) {
         this.field3914 = var1;
      }

      if(this.field3915 == -1) {
         this.field3915 = var2;
      }

      int var5 = var1 - this.field3914;
      int var6 = var2 - this.field3915;
      this.field3914 = var1;
      this.field3915 = var2;
      if(var3 && !this.method5347()) {
         this.field3921 -= (int)((float)var5 / this.field3903);
         this.field3886 += (int)((float)var6 / this.field3903);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "519993620"
   )
   void method5372(int var1, int var2, boolean var3) {
      if(FriendLoginUpdate.method1041()) {
         if(this.field3884 != null) {
            int var4 = (int)((float)this.field3921 + ((float)(var1 - this.field3925) - (float)this.method5373() * this.field3912 / 2.0F) / this.field3912);
            int var5 = (int)((float)this.field3886 - ((float)(var2 - this.field3907) - (float)this.method5374() * this.field3912 / 2.0F) / this.field3912);
            this.field3906 = this.field3884.method289(var4 + this.field3884.method340() * 64, var5 + this.field3884.method286() * 64);
            if(this.field3906 != null && var3 && KeyFocusListener.field593[82] && KeyFocusListener.field593[81] && var3) {
               FontName.method4873(this.field3906.worldX, this.field3906.worldY, this.field3906.plane);
            }
         } else {
            this.field3906 = null;
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1784079593"
   )
   void method5345() {
      if(this.field3912 < this.field3903) {
         this.field3912 = Math.min(this.field3903, this.field3912 / 30.0F + this.field3912);
      }

      if(this.field3912 > this.field3903) {
         this.field3912 = Math.max(this.field3903, this.field3912 - this.field3912 / 30.0F);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1114244061"
   )
   void method5515() {
      if(this.method5347()) {
         int var1 = this.field3900 - this.field3921;
         int var2 = this.field3901 - this.field3886;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3921 += var1;
         this.field3886 += var2;
         if(this.field3921 == this.field3900 && this.field3886 == this.field3901) {
            this.field3900 = -1;
            this.field3901 = -1;
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1684243897"
   )
   boolean method5347() {
      return this.field3900 != -1 && this.field3901 != -1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)Lax;",
      garbageValue = "-1974843351"
   )
   public WorldMapData method5348(int var1, int var2, int var3) {
      Iterator var4 = this.field3898.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method273(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIZB)V",
      garbageValue = "87"
   )
   public void method5349(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5348(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3893;
      }

      boolean var6 = false;
      if(var5 != this.field3902 || var4) {
         this.field3902 = var5;
         this.method5353(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5356(var1, var2, var3);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-63"
   )
   public void method5350(int var1) {
      WorldMapData var2 = this.method5365(var1);
      if(var2 != null) {
         this.method5353(var2);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2051959666"
   )
   public int method5351() {
      return this.field3884 == null?-1:this.field3884.method282();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Lax;",
      garbageValue = "-834766682"
   )
   public WorldMapData method5520() {
      return this.field3884;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lax;I)V",
      garbageValue = "-501550735"
   )
   void method5353(WorldMapData var1) {
      if(this.field3884 == null || var1 != this.field3884) {
         this.method5471(var1);
         this.method5356(-1, -1, -1);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lax;B)V",
      garbageValue = "0"
   )
   void method5471(WorldMapData var1) {
      this.field3884 = var1;
      this.field3899 = new class41(this.field3891, this.field3882);
      this.field3897.method5332(this.field3884.method330());
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lax;Lhc;Lhc;ZB)V",
      garbageValue = "2"
   )
   public void method5355(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3884 == null || var1 != this.field3884) {
            this.method5471(var1);
         }

         if(!var4 && this.field3884.method273(var2.plane, var2.worldX, var2.worldY)) {
            this.method5356(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5356(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1645451560"
   )
   void method5356(int var1, int var2, int var3) {
      if(this.field3884 != null) {
         int[] var4 = this.field3884.method275(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3884.method275(this.field3884.method335(), this.field3884.method288(), this.field3884.method294());
         }

         this.field3921 = var4[0] - this.field3884.method340() * 64;
         this.field3886 = var4[1] - this.field3884.method286() * 64;
         this.field3900 = -1;
         this.field3901 = -1;
         this.field3912 = this.method5361(this.field3884.method283());
         this.field3903 = this.field3912;
         this.field3923 = null;
         this.field3879 = null;
         this.field3899.method552();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1198028968"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      int var7 = this.field3897.method5329();
      if(var7 < 100) {
         this.method5465(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3899.method571()) {
            this.field3899.method551(this.field3885, this.field3884.method330(), Client.isMembers);
            if(!this.field3899.method571()) {
               return;
            }
         }

         if(this.field3911 != null) {
            ++this.field3913;
            if(this.field3913 % this.field3909 == 0) {
               this.field3913 = 0;
               ++this.field3904;
            }

            if(this.field3904 >= this.field3908 && !this.field3910) {
               this.field3911 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3912));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3912));
         this.field3899.method553(this.field3921 - var8 / 2, this.field3886 - var9 / 2, var8 / 2 + this.field3921, var9 / 2 + this.field3886, var1, var2, var3 + var1, var2 + var4);
         if(!this.field3920) {
            boolean var10 = false;
            if(var5 - this.field3880 > 100) {
               this.field3880 = var5;
               var10 = true;
            }

            this.field3899.method554(this.field3921 - var8 / 2, this.field3886 - var9 / 2, var8 / 2 + this.field3921, var9 / 2 + this.field3886, var1, var2, var3 + var1, var2 + var4, this.field3919, this.field3911, this.field3913, this.field3909, var10);
         }

         if(FriendLoginUpdate.method1041() && this.field3906 != null) {
            this.field3926.method4891("Coord: " + this.field3906, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.field3894 = var8;
         this.field3905 = var9;
         this.field3925 = var1;
         this.field3907 = var2;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "-27647"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3897.method5337()) {
         if(!this.field3899.method571()) {
            this.field3899.method551(this.field3885, this.field3884.method330(), Client.isMembers);
            if(!this.field3899.method571()) {
               return;
            }
         }

         this.field3899.method556(var1, var2, var3, var4, this.field3911, this.field3913, this.field3909);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "868931789"
   )
   public void method5359(int var1) {
      this.field3903 = this.method5361(var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1107449289"
   )
   void method5465(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3926.method4884("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)F",
      garbageValue = "4"
   )
   float method5361(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1893704894"
   )
   public int method5362() {
      return (double)this.field3903 == 1.0D?25:(1.5D == (double)this.field3903?37:(2.0D == (double)this.field3903?50:(3.0D == (double)this.field3903?75:(4.0D == (double)this.field3903?100:200))));
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-17612"
   )
   public void method5346() {
      this.field3897.method5328();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1437557893"
   )
   public boolean method5364() {
      return this.field3897.method5337();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IB)Lax;",
      garbageValue = "-80"
   )
   public WorldMapData method5365(int var1) {
      Iterator var2 = this.field3898.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method282() != var1);

      return var3;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "348550787"
   )
   public void method5366(int var1, int var2) {
      if(this.field3884 != null && this.field3884.method274(var1, var2)) {
         this.field3900 = var1 - this.field3884.method340() * 64;
         this.field3901 = var2 - this.field3884.method286() * 64;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-635420949"
   )
   public void method5367(int var1, int var2) {
      if(this.field3884 != null) {
         this.field3921 = var1 - this.field3884.method340() * 64;
         this.field3886 = var2 - this.field3884.method286() * 64;
         this.field3900 = -1;
         this.field3901 = -1;
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1302846837"
   )
   public void method5368(int var1, int var2, int var3) {
      if(this.field3884 != null) {
         int[] var4 = this.field3884.method275(var1, var2, var3);
         if(var4 != null) {
            this.method5366(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1173218720"
   )
   public void method5369(int var1, int var2, int var3) {
      if(this.field3884 != null) {
         int[] var4 = this.field3884.method275(var1, var2, var3);
         if(var4 != null) {
            this.method5367(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "49"
   )
   public int method5370() {
      return this.field3884 == null?-1:this.field3921 + this.field3884.method340() * 64;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1363234557"
   )
   public int method5371() {
      return this.field3884 == null?-1:this.field3886 + this.field3884.method286() * 64;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)Lhc;",
      garbageValue = "440025966"
   )
   public Coordinates method5431() {
      return this.field3884 == null?null:this.field3884.method289(this.method5370(), this.method5371());
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "8222"
   )
   public int method5373() {
      return this.field3894;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-81"
   )
   public int method5374() {
      return this.field3905;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "85"
   )
   public void method5478(int var1) {
      if(var1 >= 1) {
         this.field3908 = var1;
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1771290546"
   )
   public void method5375() {
      this.field3908 = 3;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1477467292"
   )
   public void method5524(int var1) {
      if(var1 >= 1) {
         this.field3909 = var1;
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1680811063"
   )
   public void method5357() {
      this.field3909 = 50;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-4"
   )
   public void method5379(boolean var1) {
      this.field3910 = var1;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1356899585"
   )
   public void method5380(int var1) {
      this.field3911 = new HashSet();
      this.field3911.add(Integer.valueOf(var1));
      this.field3904 = 0;
      this.field3913 = 0;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-56"
   )
   public void method5503(int var1) {
      this.field3911 = new HashSet();
      this.field3904 = 0;
      this.field3913 = 0;

      for(int var2 = 0; var2 < Area.mapAreaType.length; ++var2) {
         if(Area.mapAreaType[var2] != null && Area.mapAreaType[var2].field3398 == var1) {
            this.field3911.add(Integer.valueOf(Area.mapAreaType[var2].field3395));
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-61"
   )
   public void method5378() {
      this.field3911 = null;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1267078485"
   )
   public void method5383(boolean var1) {
      this.field3920 = !var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-715539683"
   )
   public void method5384(int var1, boolean var2) {
      if(!var2) {
         this.field3916.add(Integer.valueOf(var1));
      } else {
         this.field3916.remove(Integer.valueOf(var1));
      }

      this.method5389();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1275507942"
   )
   public void method5352(int var1, boolean var2) {
      if(!var2) {
         this.field3917.add(Integer.valueOf(var1));
      } else {
         this.field3917.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.mapAreaType.length; ++var3) {
         if(Area.mapAreaType[var3] != null && Area.mapAreaType[var3].field3398 == var1) {
            int var4 = Area.mapAreaType[var3].field3395;
            if(!var2) {
               this.field3918.add(Integer.valueOf(var4));
            } else {
               this.field3918.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5389();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "799234357"
   )
   public boolean method5386() {
      return !this.field3920;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-118"
   )
   public boolean method5381(int var1) {
      return !this.field3916.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1377332893"
   )
   public boolean method5388(int var1) {
      return !this.field3917.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "13438525"
   )
   void method5389() {
      this.field3919.clear();
      this.field3919.addAll(this.field3916);
      this.field3919.addAll(this.field3918);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "338728300"
   )
   public void method5442(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3897.method5337()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3912));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3912));
         List var9 = this.field3899.method557(this.field3921 - var7 / 2 - 1, this.field3886 - var8 / 2 - 1, var7 / 2 + this.field3921 + 1, var8 / 2 + this.field3886 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = Area.mapAreaType[var11.field499];
               var13 = false;

               for(int var14 = this.field3896.length - 1; var14 >= 0; --var14) {
                  if(var12.field3387[var14] != null) {
                     class37.addMenuEntry(var12.field3387[var14], var12.field3390, this.field3896[var14], var11.field499, var11.field504.method4081(), var11.field498.method4081());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(ILhc;I)Lhc;",
      garbageValue = "2086082578"
   )
   public Coordinates method5382(int var1, Coordinates var2) {
      if(!this.field3897.method5337()) {
         return null;
      } else if(!this.field3899.method571()) {
         return null;
      } else if(!this.field3884.method274(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3899.method560();
         List var4 = (List)var3.get(Integer.valueOf(var1));
         if(var4 != null && !var4.isEmpty()) {
            class39 var5 = null;
            int var6 = -1;
            Iterator var7 = var4.iterator();

            while(true) {
               class39 var8;
               int var11;
               do {
                  if(!var7.hasNext()) {
                     return var5.field498;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field498.worldX - var2.worldX;
                  int var10 = var8.field498.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field498;
                  }
               } while(var11 >= var6 && var5 != null);

               var5 = var8;
               var6 = var11;
            }
         } else {
            return null;
         }
      }
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IILhc;Lhc;I)V",
      garbageValue = "-686397480"
   )
   public void method5392(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1050(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1051(class230.field2900);
         break;
      case 1009:
         var5.method1051(class230.field2897);
         break;
      case 1010:
         var5.method1051(class230.field2906);
         break;
      case 1011:
         var5.method1051(class230.field2899);
         break;
      case 1012:
         var5.method1051(class230.field2903);
      }

      CacheFile.method2350(var5);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)Lay;",
      garbageValue = "1908580046"
   )
   public class39 method5393() {
      if(!this.field3897.method5337()) {
         return null;
      } else if(!this.field3899.method571()) {
         return null;
      } else {
         HashMap var1 = this.field3899.method560();
         this.field3923 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3923.addAll(var3);
         }

         this.field3879 = this.field3923.iterator();
         return this.method5394();
      }
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)Lay;",
      garbageValue = "-1187253180"
   )
   public class39 method5394() {
      return this.field3879 == null?null:(!this.field3879.hasNext()?null:(class39)this.field3879.next());
   }
}
