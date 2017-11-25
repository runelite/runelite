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

@ObfuscatedName("ko")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   static final class268 field3902;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   static final class268 field3896;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   static final class268 field3868;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   IndexDataBase field3865;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   Font field3866;
   @ObfuscatedName("u")
   HashMap field3890;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lkl;"
   )
   IndexedSprite[] field3887;
   @ObfuscatedName("c")
   HashMap field3872;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   WorldMapData field3903;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   WorldMapData field3874;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   WorldMapData field3875;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lan;"
   )
   class41 field3876;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   class296 field3877;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 215217419
   )
   int field3878;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 497503513
   )
   int field3879;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 855187769
   )
   int field3880;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 169583709
   )
   int field3881;
   @ObfuscatedName("w")
   float field3906;
   @ObfuscatedName("g")
   float field3883;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1111728839
   )
   int field3884;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -2104989651
   )
   int field3885;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 97218401
   )
   int field3886;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1640666301
   )
   int field3900;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -952683711
   )
   int field3888;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 442124819
   )
   int field3889;
   @ObfuscatedName("au")
   boolean field3873;
   @ObfuscatedName("al")
   HashSet field3891;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1483561231
   )
   int field3892;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 649651793
   )
   int field3893;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 124281855
   )
   int field3894;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -316657655
   )
   int field3895;
   @ObfuscatedName("ag")
   HashSet field3870;
   @ObfuscatedName("aw")
   HashSet field3871;
   @ObfuscatedName("ap")
   HashSet field3898;
   @ObfuscatedName("ad")
   HashSet field3899;
   @ObfuscatedName("an")
   boolean field3882;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1386113695
   )
   int field3901;
   @ObfuscatedName("ar")
   final int[] field3897;
   @ObfuscatedName("ac")
   List field3867;
   @ObfuscatedName("af")
   Iterator field3904;
   @ObfuscatedName("ao")
   HashSet field3905;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   Coordinates field3869;

   static {
      field3902 = class268.field3685;
      field3896 = class268.field3686;
      field3868 = class268.field3684;
   }

   public RenderOverview() {
      this.field3880 = -1;
      this.field3881 = -1;
      this.field3884 = -1;
      this.field3885 = -1;
      this.field3886 = -1;
      this.field3900 = -1;
      this.field3888 = 3;
      this.field3889 = 50;
      this.field3873 = false;
      this.field3891 = null;
      this.field3892 = -1;
      this.field3893 = -1;
      this.field3894 = -1;
      this.field3895 = -1;
      this.field3870 = new HashSet();
      this.field3871 = new HashSet();
      this.field3898 = new HashSet();
      this.field3899 = new HashSet();
      this.field3882 = false;
      this.field3901 = 0;
      this.field3897 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3905 = new HashSet();
      this.field3869 = null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;Ljp;Ljava/util/HashMap;[Lkl;B)V",
      garbageValue = "76"
   )
   public void method5500(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field3887 = var4;
      this.field3865 = var1;
      this.field3866 = var2;
      this.field3890 = new HashMap();
      this.field3890.put(class24.field343, var3.get(field3902));
      this.field3890.put(class24.field341, var3.get(field3896));
      this.field3890.put(class24.field342, var3.get(field3868));
      this.field3877 = new class296(var1);
      int var5 = this.field3865.getFile(class40.field514.field517);
      int[] var6 = this.field3865.getChilds(var5);
      this.field3872 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3865.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3872.put(var9.method283(), var9);
         if(var9.method303()) {
            this.field3903 = var9;
         }
      }

      this.method5406(this.field3903);
      this.field3875 = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1164037371"
   )
   public int method5394() {
      return this.field3865.method4285(this.field3903.method283(), class40.field519.field517)?100:this.field3865.method4296(this.field3903.method283());
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "974891042"
   )
   public void method5395(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3877.method5380()) {
         this.method5398();
         this.method5399();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3906));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3906));
            List var10 = this.field3876.method564(this.field3878 - var8 / 2 - 1, this.field3879 - var9 / 2 - 1, var8 / 2 + this.field3878 + 1, var9 / 2 + this.field3879 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); class14.method95(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field513, var13.field507, var13.field506);
               var14.method1122(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3905.contains(var13)) {
                  var14.method1117(class226.field2869);
               } else {
                  var14.method1117(class226.field2867);
               }
            }

            var12 = this.field3905.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field513, var13.field507, var13.field506);
                  var14.method1122(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1117(class226.field2870);
                  class14.method95(var14);
               }
            }

            this.field3905 = var11;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIZZB)V",
      garbageValue = "9"
   )
   public void method5497(int var1, int var2, boolean var3, boolean var4) {
      this.method5471(var1, var2, var4);
      if(this.field3894 == -1) {
         this.field3894 = var1;
      }

      if(this.field3895 == -1) {
         this.field3895 = var2;
      }

      int var5 = var1 - this.field3894;
      int var6 = var2 - this.field3895;
      this.field3894 = var1;
      this.field3895 = var2;
      if(var3 && !this.method5452()) {
         this.field3878 -= (int)((float)var5 / this.field3883);
         this.field3879 += (int)((float)var6 / this.field3883);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "2087686781"
   )
   void method5471(int var1, int var2, boolean var3) {
      boolean var4 = Client.rights >= 2;
      if(var4) {
         if(this.field3874 != null) {
            int var5 = (int)((float)this.field3878 + ((float)(var1 - this.field3886) - (float)this.method5426() * this.field3906 / 2.0F) / this.field3906);
            int var6 = (int)((float)this.field3879 - ((float)(var2 - this.field3900) - (float)this.method5427() * this.field3906 / 2.0F) / this.field3906);
            this.field3869 = this.field3874.method291(var5 + this.field3874.method287() * 64, var6 + this.field3874.method289() * 64);
            if(this.field3869 != null && var3 && KeyFocusListener.field606[82] && KeyFocusListener.field606[81] && var3) {
               int var7 = this.field3869.worldX;
               int var8 = this.field3869.worldY;
               int var9 = this.field3869.plane;
               PacketNode var10 = class218.method4105(ClientPacket.field2375, Client.field916.field1470);
               var10.packetBuffer.method3343(var9);
               var10.packetBuffer.putShortLE(var7);
               var10.packetBuffer.method3332(var8);
               Client.field916.method1925(var10);
            }
         } else {
            this.field3869 = null;
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-796880729"
   )
   void method5398() {
      if(this.field3906 < this.field3883) {
         this.field3906 = Math.min(this.field3883, this.field3906 + this.field3906 / 30.0F);
      }

      if(this.field3906 > this.field3883) {
         this.field3906 = Math.max(this.field3883, this.field3906 - this.field3906 / 30.0F);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-880017588"
   )
   void method5399() {
      if(this.method5452()) {
         int var1 = this.field3880 - this.field3878;
         int var2 = this.field3881 - this.field3879;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3878 += var1;
         this.field3879 += var2;
         if(this.field3880 == this.field3878 && this.field3879 == this.field3881) {
            this.field3880 = -1;
            this.field3881 = -1;
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1873910312"
   )
   boolean method5452() {
      return this.field3880 != -1 && this.field3881 != -1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)Lal;",
      garbageValue = "677982634"
   )
   public WorldMapData method5401(int var1, int var2, int var3) {
      Iterator var4 = this.field3872.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method276(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "23136804"
   )
   public void method5402(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5401(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3903;
      }

      boolean var6 = false;
      if(var5 != this.field3875 || var4) {
         this.field3875 = var5;
         this.method5406(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5409(var1, var2, var3);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "7"
   )
   public void method5403(int var1) {
      WorldMapData var2 = this.method5418(var1);
      if(var2 != null) {
         this.method5406(var2);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1258061866"
   )
   public int method5555() {
      return this.field3874 == null?-1:this.field3874.method281();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Lal;",
      garbageValue = "-75"
   )
   public WorldMapData method5486() {
      return this.field3874;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lal;I)V",
      garbageValue = "1178830553"
   )
   void method5406(WorldMapData var1) {
      if(this.field3874 == null || var1 != this.field3874) {
         this.method5407(var1);
         this.method5409(-1, -1, -1);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lal;B)V",
      garbageValue = "-3"
   )
   void method5407(WorldMapData var1) {
      this.field3874 = var1;
      this.field3876 = new class41(this.field3887, this.field3890);
      this.field3877.method5391(this.field3874.method283());
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lal;Lhp;Lhp;ZI)V",
      garbageValue = "-1820279264"
   )
   public void method5573(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3874 == null || var1 != this.field3874) {
            this.method5407(var1);
         }

         if(!var4 && this.field3874.method276(var2.plane, var2.worldX, var2.worldY)) {
            this.method5409(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5409(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "1"
   )
   void method5409(int var1, int var2, int var3) {
      if(this.field3874 != null) {
         int[] var4 = this.field3874.method278(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3874.method278(this.field3874.method292(), this.field3874.method328(), this.field3874.method293());
         }

         this.field3878 = var4[0] - this.field3874.method287() * 64;
         this.field3879 = var4[1] - this.field3874.method289() * 64;
         this.field3880 = -1;
         this.field3881 = -1;
         this.field3906 = this.method5414(this.field3874.method286());
         this.field3883 = this.field3906;
         this.field3867 = null;
         this.field3904 = null;
         this.field3876.method571();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "630958901"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.method5173(var1, var2, var3, var4, -16777216);
      int var7 = this.field3877.method5381();
      if(var7 < 100) {
         this.method5413(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3876.method582()) {
            this.field3876.method558(this.field3865, this.field3874.method283(), Client.isMembers);
            if(!this.field3876.method582()) {
               return;
            }
         }

         if(this.field3891 != null) {
            ++this.field3893;
            if(this.field3893 % this.field3889 == 0) {
               this.field3893 = 0;
               ++this.field3892;
            }

            if(this.field3892 >= this.field3888 && !this.field3873) {
               this.field3891 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3906));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3906));
         this.field3876.method560(this.field3878 - var8 / 2, this.field3879 - var9 / 2, var8 / 2 + this.field3878, var9 / 2 + this.field3879, var1, var2, var3 + var1, var2 + var4);
         boolean var10;
         if(!this.field3882) {
            var10 = false;
            if(var5 - this.field3901 > 100) {
               this.field3901 = var5;
               var10 = true;
            }

            this.field3876.method561(this.field3878 - var8 / 2, this.field3879 - var9 / 2, var8 / 2 + this.field3878, var9 / 2 + this.field3879, var1, var2, var3 + var1, var2 + var4, this.field3899, this.field3891, this.field3893, this.field3889, var10);
         }

         var10 = Client.rights >= 2;
         if(var10 && this.field3869 != null) {
            this.field3866.method4931("Coord: " + this.field3869, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.field3884 = var8;
         this.field3885 = var9;
         this.field3886 = var1;
         this.field3900 = var2;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-71"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3877.method5380()) {
         if(!this.field3876.method582()) {
            this.field3876.method558(this.field3865, this.field3874.method283(), Client.isMembers);
            if(!this.field3876.method582()) {
               return;
            }
         }

         this.field3876.method563(var1, var2, var3, var4, this.field3891, this.field3893, this.field3889);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-700625360"
   )
   public void method5519(int var1) {
      this.field3883 = this.method5414(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1332636168"
   )
   void method5413(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.method5173(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method5173(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3866.method4962("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "-1244049778"
   )
   float method5414(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "334774931"
   )
   public int method5415() {
      return (double)this.field3883 == 1.0D?25:(1.5D == (double)this.field3883?37:(2.0D == (double)this.field3883?50:(3.0D == (double)this.field3883?75:(4.0D == (double)this.field3883?100:200))));
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1174009561"
   )
   public void method5416() {
      this.field3877.method5384();
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2113109889"
   )
   public boolean method5417() {
      return this.field3877.method5380();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)Lal;",
      garbageValue = "-212996051"
   )
   public WorldMapData method5418(int var1) {
      Iterator var2 = this.field3872.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method281() != var1);

      return var3;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1643496532"
   )
   public void method5419(int var1, int var2) {
      if(this.field3874 != null && this.field3874.method277(var1, var2)) {
         this.field3880 = var1 - this.field3874.method287() * 64;
         this.field3881 = var2 - this.field3874.method289() * 64;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1958255252"
   )
   public void method5420(int var1, int var2) {
      if(this.field3874 != null) {
         this.field3878 = var1 - this.field3874.method287() * 64;
         this.field3879 = var2 - this.field3874.method289() * 64;
         this.field3880 = -1;
         this.field3881 = -1;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "6"
   )
   public void method5543(int var1, int var2, int var3) {
      if(this.field3874 != null) {
         int[] var4 = this.field3874.method278(var1, var2, var3);
         if(var4 != null) {
            this.method5419(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "902608127"
   )
   public void method5422(int var1, int var2, int var3) {
      if(this.field3874 != null) {
         int[] var4 = this.field3874.method278(var1, var2, var3);
         if(var4 != null) {
            this.method5420(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int method5470() {
      return this.field3874 == null?-1:this.field3878 + this.field3874.method287() * 64;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1521630827"
   )
   public int method5424() {
      return this.field3874 == null?-1:this.field3879 + this.field3874.method289() * 64;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)Lhp;",
      garbageValue = "-2018644609"
   )
   public Coordinates method5425() {
      return this.field3874 == null?null:this.field3874.method291(this.method5470(), this.method5424());
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-607924382"
   )
   public int method5426() {
      return this.field3884;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "10"
   )
   public int method5427() {
      return this.field3885;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-13"
   )
   public void method5428(int var1) {
      if(var1 >= 1) {
         this.field3888 = var1;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-785431936"
   )
   public void method5429() {
      this.field3888 = 3;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1659482720"
   )
   public void method5435(int var1) {
      if(var1 >= 1) {
         this.field3889 = var1;
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1088771937"
   )
   public void method5431() {
      this.field3889 = 50;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1811625995"
   )
   public void method5582(boolean var1) {
      this.field3873 = var1;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2008578811"
   )
   public void method5562(int var1) {
      this.field3891 = new HashSet();
      this.field3891.add(Integer.valueOf(var1));
      this.field3892 = 0;
      this.field3893 = 0;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1931054798"
   )
   public void method5558(int var1) {
      this.field3891 = new HashSet();
      this.field3892 = 0;
      this.field3893 = 0;

      for(int var2 = 0; var2 < Area.mapAreaType.length; ++var2) {
         if(Area.mapAreaType[var2] != null && Area.mapAreaType[var2].field3384 == var1) {
            this.field3891.add(Integer.valueOf(Area.mapAreaType[var2].field3366));
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1561927544"
   )
   public void method5550() {
      this.field3891 = null;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "56"
   )
   public void method5465(boolean var1) {
      this.field3882 = !var1;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "2"
   )
   public void method5437(int var1, boolean var2) {
      if(!var2) {
         this.field3870.add(Integer.valueOf(var1));
      } else {
         this.field3870.remove(Integer.valueOf(var1));
      }

      this.method5442();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-125930890"
   )
   public void method5438(int var1, boolean var2) {
      if(!var2) {
         this.field3871.add(Integer.valueOf(var1));
      } else {
         this.field3871.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.mapAreaType.length; ++var3) {
         if(Area.mapAreaType[var3] != null && Area.mapAreaType[var3].field3384 == var1) {
            int var4 = Area.mapAreaType[var3].field3366;
            if(!var2) {
               this.field3898.add(Integer.valueOf(var4));
            } else {
               this.field3898.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5442();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-92"
   )
   public boolean method5439() {
      return !this.field3882;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "571559687"
   )
   public boolean method5518(int var1) {
      return !this.field3870.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-4"
   )
   public boolean method5474(int var1) {
      return !this.field3871.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1636160157"
   )
   void method5442() {
      this.field3899.clear();
      this.field3899.addAll(this.field3870);
      this.field3899.addAll(this.field3898);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "554585142"
   )
   public void method5441(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3877.method5380()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3906));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3906));
         List var9 = this.field3876.method564(this.field3878 - var7 / 2 - 1, this.field3879 - var8 / 2 - 1, var7 / 2 + this.field3878 + 1, var8 / 2 + this.field3879 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = Area.mapAreaType[var11.field513];
               var13 = false;

               for(int var14 = this.field3897.length - 1; var14 >= 0; --var14) {
                  if(var12.field3377[var14] != null) {
                     RSCanvas.addMenuEntry(var12.field3377[var14], var12.field3374, this.field3897[var14], var11.field513, var11.field507.method4109(), var11.field506.method4109());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(ILhp;S)Lhp;",
      garbageValue = "-26812"
   )
   public Coordinates method5444(int var1, Coordinates var2) {
      if(!this.field3877.method5380()) {
         return null;
      } else if(!this.field3876.method582()) {
         return null;
      } else if(!this.field3874.method277(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3876.method600();
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
                     return var5.field506;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field506.worldX - var2.worldX;
                  int var10 = var8.field506.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field506;
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

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(IILhp;Lhp;I)V",
      garbageValue = "-1527774136"
   )
   public void method5445(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1122(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1117(class226.field2871);
         break;
      case 1009:
         var5.method1117(class226.field2865);
         break;
      case 1010:
         var5.method1117(class226.field2872);
         break;
      case 1011:
         var5.method1117(class226.field2864);
         break;
      case 1012:
         var5.method1117(class226.field2868);
      }

      class14.method95(var5);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I)Lap;",
      garbageValue = "-195807008"
   )
   public class39 method5495() {
      if(!this.field3877.method5380()) {
         return null;
      } else if(!this.field3876.method582()) {
         return null;
      } else {
         HashMap var1 = this.field3876.method600();
         this.field3867 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3867.addAll(var3);
         }

         this.field3904 = this.field3867.iterator();
         return this.method5447();
      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(B)Lap;",
      garbageValue = "125"
   )
   public class39 method5447() {
      return this.field3904 == null?null:(!this.field3904.hasNext()?null:(class39)this.field3904.next());
   }
}
