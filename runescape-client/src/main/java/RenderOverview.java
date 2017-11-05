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
import net.runelite.rs.Opcodes;

@ObfuscatedName("kk")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   static final class261 field3824;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   static final class261 field3841;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   static final class261 field3826;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   IndexDataBase field3829;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   Font field3835;
   @ObfuscatedName("n")
   HashMap field3842;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Ljo;"
   )
   IndexedSprite[] field3847;
   @ObfuscatedName("t")
   HashMap field3830;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   WorldMapData field3831;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   WorldMapData field3832;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   WorldMapData field3833;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   class41 field3834;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   class288 field3861;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -835912511
   )
   int field3836;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 615852833
   )
   int field3827;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 119798483
   )
   int field3838;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1498046183
   )
   int field3822;
   @ObfuscatedName("m")
   float field3840;
   @ObfuscatedName("l")
   float field3851;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1429783605
   )
   int field3839;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1220538825
   )
   int field3843;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1311020657
   )
   int field3858;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1865998161
   )
   int field3845;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1498430671
   )
   int field3846;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 619258345
   )
   int field3862;
   @ObfuscatedName("az")
   boolean field3848;
   @ObfuscatedName("at")
   HashSet field3849;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 270029937
   )
   int field3850;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 818586383
   )
   int field3859;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -467471189
   )
   int field3853;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -579166409
   )
   int field3823;
   @ObfuscatedName("al")
   HashSet field3854;
   @ObfuscatedName("ae")
   HashSet field3855;
   @ObfuscatedName("ab")
   HashSet field3837;
   @ObfuscatedName("aj")
   HashSet field3857;
   @ObfuscatedName("ac")
   boolean field3856;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1032607315
   )
   int field3828;
   @ObfuscatedName("ah")
   final int[] field3844;
   @ObfuscatedName("ak")
   List field3818;
   @ObfuscatedName("ar")
   Iterator field3852;
   @ObfuscatedName("ag")
   HashSet field3863;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   Coordinates field3864;

   static {
      field3824 = class261.field3628;
      field3841 = class261.field3622;
      field3826 = class261.field3627;
   }

   public RenderOverview() {
      this.field3838 = -1;
      this.field3822 = -1;
      this.field3839 = -1;
      this.field3843 = -1;
      this.field3858 = -1;
      this.field3845 = -1;
      this.field3846 = 3;
      this.field3862 = 50;
      this.field3848 = false;
      this.field3849 = null;
      this.field3850 = -1;
      this.field3859 = -1;
      this.field3853 = -1;
      this.field3823 = -1;
      this.field3854 = new HashSet();
      this.field3855 = new HashSet();
      this.field3837 = new HashSet();
      this.field3857 = new HashSet();
      this.field3856 = false;
      this.field3828 = 0;
      this.field3844 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3863 = new HashSet();
      this.field3864 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lip;Ljh;Ljava/util/HashMap;[Ljo;I)V",
      garbageValue = "2016024681"
   )
   public void method5294(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field3847 = var4;
      this.field3829 = var1;
      this.field3835 = var2;
      this.field3842 = new HashMap();
      this.field3842.put(class24.field378, var3.get(field3824));
      this.field3842.put(class24.field369, var3.get(field3841));
      this.field3842.put(class24.field370, var3.get(field3826));
      this.field3861 = new class288(var1);
      int var5 = this.field3829.getFile(class40.field567.field563);
      int[] var6 = this.field3829.getChilds(var5);
      this.field3830 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3829.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3830.put(var9.method277(), var9);
         if(var9.method286()) {
            this.field3831 = var9;
         }
      }

      this.method5399(this.field3831);
      this.field3833 = null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "77"
   )
   public int method5295() {
      return this.field3829.method4210(this.field3831.method277(), class40.field566.field563)?100:this.field3829.method4213(this.field3831.method277());
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "211394972"
   )
   public void method5483(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3861.method5289()) {
         this.method5299();
         this.method5300();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3840));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3840));
            List var10 = this.field3834.method579(this.field3836 - var8 / 2 - 1, this.field3827 - var9 / 2 - 1, var8 / 2 + this.field3836 + 1, var9 / 2 + this.field3827 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); class56.method817(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field556, var13.field559, var13.field548);
               var14.method1098(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3863.contains(var13)) {
                  var14.method1096(class219.field2783);
               } else {
                  var14.method1096(class219.field2785);
               }
            }

            var12 = this.field3863.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field556, var13.field559, var13.field548);
                  var14.method1098(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1096(class219.field2784);
                  class56.method817(var14);
               }
            }

            this.field3863 = var11;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIZZI)V",
      garbageValue = "2127053392"
   )
   public void method5297(int var1, int var2, boolean var3, boolean var4) {
      this.method5409(var1, var2, var4);
      if(this.field3853 == -1) {
         this.field3853 = var1;
      }

      if(this.field3823 == -1) {
         this.field3823 = var2;
      }

      int var5 = var1 - this.field3853;
      int var6 = var2 - this.field3823;
      this.field3853 = var1;
      this.field3823 = var2;
      if(var3 && !this.method5467()) {
         this.field3836 -= (int)((float)var5 / this.field3851);
         this.field3827 += (int)((float)var6 / this.field3851);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "-108"
   )
   void method5409(int var1, int var2, boolean var3) {
      boolean var4 = Client.rights >= 2;
      if(var4) {
         if(this.field3832 != null) {
            int var5 = (int)((float)this.field3836 + ((float)(var1 - this.field3858) - (float)this.method5358() * this.field3840 / 2.0F) / this.field3840);
            int var6 = (int)((float)this.field3827 - ((float)(var2 - this.field3845) - (float)this.method5411() * this.field3840 / 2.0F) / this.field3840);
            this.field3864 = this.field3832.method283(var5 + this.field3832.method291() * 64, var6 + this.field3832.method293() * 64);
            if(this.field3864 != null && var3 && KeyFocusListener.field659[82] && KeyFocusListener.field659[81] && var3) {
               int var7 = this.field3864.worldX;
               int var8 = this.field3864.worldY;
               int var9 = this.field3864.plane;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_30);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var8);
                  Client.secretPacketBuffer1.runeliteWriteInt(var7);
                  Client.secretPacketBuffer1.runeliteWriteInt(var9);
               } else {
                  Client.secretPacketBuffer1.method3342(var8);
                  Client.secretPacketBuffer1.method3342(var7);
                  Client.secretPacketBuffer1.putLEInt(var9);
               }
            }
         } else {
            this.field3864 = null;
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "34"
   )
   void method5299() {
      if(this.field3840 < this.field3851) {
         this.field3840 = Math.min(this.field3851, this.field3840 + this.field3840 / 30.0F);
      }

      if(this.field3840 > this.field3851) {
         this.field3840 = Math.max(this.field3851, this.field3840 - this.field3840 / 30.0F);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1073663602"
   )
   void method5300() {
      if(this.method5467()) {
         int var1 = this.field3838 - this.field3836;
         int var2 = this.field3822 - this.field3827;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3836 += var1;
         this.field3827 += var2;
         if(this.field3838 == this.field3836 && this.field3822 == this.field3827) {
            this.field3838 = -1;
            this.field3822 = -1;
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-462791896"
   )
   boolean method5467() {
      return this.field3838 != -1 && this.field3822 != -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)Lat;",
      garbageValue = "-1789686883"
   )
   public WorldMapData method5482(int var1, int var2, int var3) {
      Iterator var4 = this.field3830.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method280(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1058518272"
   )
   public void method5366(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5482(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3831;
      }

      boolean var6 = false;
      if(var5 != this.field3833 || var4) {
         this.field3833 = var5;
         this.method5399(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5310(var1, var2, var3);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "784623161"
   )
   public void method5304(int var1) {
      WorldMapData var2 = this.method5319(var1);
      if(var2 != null) {
         this.method5399(var2);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "205"
   )
   public int method5305() {
      return this.field3832 == null?-1:this.field3832.method285();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Lat;",
      garbageValue = "-1492879391"
   )
   public WorldMapData method5306() {
      return this.field3832;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lat;I)V",
      garbageValue = "-44577804"
   )
   void method5399(WorldMapData var1) {
      if(this.field3832 == null || var1 != this.field3832) {
         this.method5308(var1);
         this.method5310(-1, -1, -1);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lat;I)V",
      garbageValue = "-229219682"
   )
   void method5308(WorldMapData var1) {
      this.field3832 = var1;
      this.field3834 = new class41(this.field3847, this.field3842);
      this.field3861.method5279(this.field3832.method277());
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lat;Lhg;Lhg;ZI)V",
      garbageValue = "1555316713"
   )
   public void method5309(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3832 == null || var1 != this.field3832) {
            this.method5308(var1);
         }

         if(!var4 && this.field3832.method280(var2.plane, var2.worldX, var2.worldY)) {
            this.method5310(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5310(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1442281936"
   )
   void method5310(int var1, int var2, int var3) {
      if(this.field3832 != null) {
         int[] var4 = this.field3832.method324(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3832.method324(this.field3832.method346(), this.field3832.method295(), this.field3832.method279());
         }

         this.field3836 = var4[0] - this.field3832.method291() * 64;
         this.field3827 = var4[1] - this.field3832.method293() * 64;
         this.field3838 = -1;
         this.field3822 = -1;
         this.field3840 = this.method5315(this.field3832.method303());
         this.field3851 = this.field3840;
         this.field3818 = null;
         this.field3852 = null;
         this.field3834.method567();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-340069017"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.method5045(var1, var2, var3, var4, -16777216);
      int var7 = this.field3861.method5282();
      if(var7 < 100) {
         this.method5314(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3834.method549()) {
            this.field3834.method541(this.field3829, this.field3832.method277(), Client.isMembers);
            if(!this.field3834.method549()) {
               return;
            }
         }

         if(this.field3849 != null) {
            ++this.field3859;
            if(this.field3859 % this.field3862 == 0) {
               this.field3859 = 0;
               ++this.field3850;
            }

            if(this.field3850 >= this.field3846 && !this.field3848) {
               this.field3849 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3840));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3840));
         this.field3834.method584(this.field3836 - var8 / 2, this.field3827 - var9 / 2, var8 / 2 + this.field3836, var9 / 2 + this.field3827, var1, var2, var3 + var1, var2 + var4);
         boolean var10;
         if(!this.field3856) {
            var10 = false;
            if(var5 - this.field3828 > 100) {
               this.field3828 = var5;
               var10 = true;
            }

            this.field3834.method544(this.field3836 - var8 / 2, this.field3827 - var9 / 2, var8 / 2 + this.field3836, var9 / 2 + this.field3827, var1, var2, var3 + var1, var2 + var4, this.field3857, this.field3849, this.field3859, this.field3862, var10);
         }

         var10 = Client.rights >= 2;
         if(var10 && this.field3864 != null) {
            this.field3835.method4842("Coord: " + this.field3864, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.field3839 = var8;
         this.field3843 = var9;
         this.field3858 = var1;
         this.field3845 = var2;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1016594702"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3861.method5289()) {
         if(!this.field3834.method549()) {
            this.field3834.method541(this.field3829, this.field3832.method277(), Client.isMembers);
            if(!this.field3834.method549()) {
               return;
            }
         }

         this.field3834.method546(var1, var2, var3, var4, this.field3849, this.field3859, this.field3862);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2116524232"
   )
   public void method5313(int var1) {
      this.field3851 = this.method5315(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "872930924"
   )
   void method5314(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.method5045(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method5045(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3835.method4845("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "-1442639849"
   )
   float method5315(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1590322602"
   )
   public int method5298() {
      return 1.0D == (double)this.field3851?25:((double)this.field3851 == 1.5D?37:((double)this.field3851 == 2.0D?50:((double)this.field3851 == 3.0D?75:((double)this.field3851 == 4.0D?100:200))));
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-159721461"
   )
   public void method5367() {
      this.field3861.method5290();
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1572453776"
   )
   public boolean method5438() {
      return this.field3861.method5289();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)Lat;",
      garbageValue = "768698722"
   )
   public WorldMapData method5319(int var1) {
      Iterator var2 = this.field3830.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method285() != var1);

      return var3;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-115"
   )
   public void method5320(int var1, int var2) {
      if(this.field3832 != null && this.field3832.method300(var1, var2)) {
         this.field3838 = var1 - this.field3832.method291() * 64;
         this.field3822 = var2 - this.field3832.method293() * 64;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-3"
   )
   public void method5321(int var1, int var2) {
      if(this.field3832 != null) {
         this.field3836 = var1 - this.field3832.method291() * 64;
         this.field3827 = var2 - this.field3832.method293() * 64;
         this.field3838 = -1;
         this.field3822 = -1;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "25"
   )
   public void method5470(int var1, int var2, int var3) {
      if(this.field3832 != null) {
         int[] var4 = this.field3832.method324(var1, var2, var3);
         if(var4 != null) {
            this.method5320(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1935858996"
   )
   public void method5323(int var1, int var2, int var3) {
      if(this.field3832 != null) {
         int[] var4 = this.field3832.method324(var1, var2, var3);
         if(var4 != null) {
            this.method5321(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2098018550"
   )
   public int method5324() {
      return this.field3832 == null?-1:this.field3836 + this.field3832.method291() * 64;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1634613861"
   )
   public int method5325() {
      return this.field3832 == null?-1:this.field3827 + this.field3832.method293() * 64;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)Lhg;",
      garbageValue = "930830529"
   )
   public Coordinates method5293() {
      return this.field3832 == null?null:this.field3832.method283(this.method5324(), this.method5325());
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2010494450"
   )
   public int method5358() {
      return this.field3839;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method5411() {
      return this.field3843;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "968240575"
   )
   public void method5329(int var1) {
      if(var1 >= 1) {
         this.field3846 = var1;
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1564525689"
   )
   public void method5330() {
      this.field3846 = 3;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1307608208"
   )
   public void method5331(int var1) {
      if(var1 >= 1) {
         this.field3862 = var1;
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1885950738"
   )
   public void method5332() {
      this.field3862 = 50;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1801630615"
   )
   public void method5333(boolean var1) {
      this.field3848 = var1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public void method5369(int var1) {
      this.field3849 = new HashSet();
      this.field3849.add(Integer.valueOf(var1));
      this.field3850 = 0;
      this.field3859 = 0;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-918914724"
   )
   public void method5335(int var1) {
      this.field3849 = new HashSet();
      this.field3850 = 0;
      this.field3859 = 0;

      for(int var2 = 0; var2 < Area.field3285.length; ++var2) {
         if(Area.field3285[var2] != null && Area.field3285[var2].field3304 == var1) {
            this.field3849.add(Integer.valueOf(Area.field3285[var2].field3287));
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "99"
   )
   public void method5405() {
      this.field3849 = null;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1155988265"
   )
   public void method5360(boolean var1) {
      this.field3856 = !var1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-954034263"
   )
   public void method5338(int var1, boolean var2) {
      if(!var2) {
         this.field3854.add(Integer.valueOf(var1));
      } else {
         this.field3854.remove(Integer.valueOf(var1));
      }

      this.method5343();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1203896536"
   )
   public void method5451(int var1, boolean var2) {
      if(!var2) {
         this.field3855.add(Integer.valueOf(var1));
      } else {
         this.field3855.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.field3285.length; ++var3) {
         if(Area.field3285[var3] != null && Area.field3285[var3].field3304 == var1) {
            int var4 = Area.field3285[var3].field3287;
            if(!var2) {
               this.field3837.add(Integer.valueOf(var4));
            } else {
               this.field3837.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5343();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1795462703"
   )
   public boolean method5340() {
      return !this.field3856;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1485258014"
   )
   public boolean method5341(int var1) {
      return !this.field3854.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "110"
   )
   public boolean method5342(int var1) {
      return !this.field3855.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "20"
   )
   void method5343() {
      this.field3857.clear();
      this.field3857.addAll(this.field3854);
      this.field3857.addAll(this.field3837);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "825091479"
   )
   public void method5442(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3861.method5289()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3840));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3840));
         List var9 = this.field3834.method579(this.field3836 - var7 / 2 - 1, this.field3827 - var8 / 2 - 1, var7 / 2 + this.field3836 + 1, var8 / 2 + this.field3827 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = Area.field3285[var11.field556];
               var13 = false;

               for(int var14 = this.field3844.length - 1; var14 >= 0; --var14) {
                  if(var12.field3293[var14] != null) {
                     class215.addMenuEntry(var12.field3293[var14], var12.field3291, this.field3844[var14], var11.field556, var11.field559.method4014(), var11.field548.method4014());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(ILhg;I)Lhg;",
      garbageValue = "-1725391853"
   )
   public Coordinates method5337(int var1, Coordinates var2) {
      if(!this.field3861.method5289()) {
         return null;
      } else if(!this.field3834.method549()) {
         return null;
      } else if(!this.field3832.method300(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3834.method550();
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
                     return var5.field548;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field548.worldX - var2.worldX;
                  int var10 = var8.field548.worldY - var2.worldY;
                  var11 = var10 * var10 + var9 * var9;
                  if(var11 == 0) {
                     return var8.field548;
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

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IILhg;Lhg;B)V",
      garbageValue = "9"
   )
   public void method5346(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1098(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1096(class219.field2779);
         break;
      case 1009:
         var5.method1096(class219.field2778);
         break;
      case 1010:
         var5.method1096(class219.field2780);
         break;
      case 1011:
         var5.method1096(class219.field2781);
         break;
      case 1012:
         var5.method1096(class219.field2782);
      }

      class56.method817(var5);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)Lab;",
      garbageValue = "218194796"
   )
   public class39 method5296() {
      if(!this.field3861.method5289()) {
         return null;
      } else if(!this.field3834.method549()) {
         return null;
      } else {
         HashMap var1 = this.field3834.method550();
         this.field3818 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3818.addAll(var3);
         }

         this.field3852 = this.field3818.iterator();
         return this.method5348();
      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(S)Lab;",
      garbageValue = "18547"
   )
   public class39 method5348() {
      return this.field3852 == null?null:(!this.field3852.hasNext()?null:(class39)this.field3852.next());
   }
}
