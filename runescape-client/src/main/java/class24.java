import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public final class class24 extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2041540315
   )
   int field602;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -100998477
   )
   int field603;
   @ObfuscatedName("j")
   static Deque field604 = new Deque();
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1459349579
   )
   int field605;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1179005941
   )
   int field606;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1574554673
   )
   int field607;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1008439091
   )
   int field608;
   @ObfuscatedName("f")
   class67 field610;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1141704037
   )
   int field611;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1272815391
   )
   int field612;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -16802127
   )
   int field613;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -850820625
   )
   int field614;
   @ObfuscatedName("g")
   class67 field615;
   @ObfuscatedName("r")
   ObjectComposition field616;
   @ObfuscatedName("q")
   int[] field619;
   @ObfuscatedName("n")
   public static String field620;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-80"
   )
   void method568() {
      int var1 = this.field611;
      ObjectComposition var2 = this.field616.getImpostor();
      if(null != var2) {
         this.field611 = var2.field948;
         this.field608 = var2.field968 * 128;
         this.field603 = var2.field929;
         this.field612 = var2.field974;
         this.field619 = var2.field964;
      } else {
         this.field611 = -1;
         this.field608 = 0;
         this.field603 = 0;
         this.field612 = 0;
         this.field619 = null;
      }

      if(this.field611 != var1 && this.field610 != null) {
         class14.field205.method1180(this.field610);
         this.field610 = null;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIB)[LModIcon;",
      garbageValue = "54"
   )
   static ModIcon[] method569(class170 var0, int var1, int var2) {
      if(!NPCComposition.method775(var0, var1, var2)) {
         return null;
      } else {
         ModIcon[] var4 = new ModIcon[class79.field1420];

         for(int var5 = 0; var5 < class79.field1420; ++var5) {
            ModIcon var6 = var4[var5] = new ModIcon();
            var6.width = class79.field1422;
            var6.originalHeight = class79.field1419;
            var6.offsetX = class79.field1421[var5];
            var6.offsetY = class79.field1423[var5];
            var6.originalWidth = class20.field567[var5];
            var6.height = class79.field1424[var5];
            var6.palette = class79.field1425;
            var6.pixels = class13.field191[var5];
         }

         Friend.method193();
         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "912427934"
   )
   static void method573() {
      class5.field73 = 99;
      class5.field85 = new byte[4][104][104];
      class109.field1921 = new byte[4][104][104];
      class5.field75 = new byte[4][104][104];
      class5.field76 = new byte[4][104][104];
      class220.field3214 = new int[4][105][105];
      class132.field2104 = new byte[4][105][105];
      class5.field74 = new int[105][105];
      class18.field257 = new int[104];
      class5.field78 = new int[104];
      class5.field79 = new int[104];
      class172.field2766 = new int[104];
      class12.field184 = new int[104];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)LSpritePixels;",
      garbageValue = "123973715"
   )
   public static SpritePixels method574(class170 var0, String var1, String var2) {
      int var3 = var0.method3359(var1);
      int var4 = var0.method3305(var3, var2);
      return class43.method856(var0, var3, var4);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-113"
   )
   static final void method576(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class94.field1639[var6];
         var12 = class94.field1640[var6];
         var13 = var12 * var9 - var5 * var11 >> 16;
         var10 = var5 * var12 + var11 * var9 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class94.field1639[var7];
         var12 = class94.field1640[var7];
         var13 = var12 * var8 + var10 * var11 >> 16;
         var10 = var10 * var12 - var11 * var8 >> 16;
         var8 = var13;
      }

      Ignore.cameraX = var0 - var8;
      class119.cameraZ = var1 - var9;
      WallObject.cameraY = var2 - var10;
      class53.cameraPitch = var3;
      Client.cameraYaw = var4;
   }

   @ObfuscatedName("r")
   static final void method577(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILclass170;IIIZI)V",
      garbageValue = "2042135045"
   )
   public static void method578(int var0, class170 var1, int var2, int var3, int var4, boolean var5) {
      class186.field3009 = 1;
      class186.field3010 = var1;
      class156.field2330 = var2;
      class128.field2091 = var3;
      class186.field3011 = var4;
      class186.field3016 = var5;
      class35.field785 = var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "-2105121372"
   )
   public static final void method579(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= '뮀') {
         class59.field1228 = var0;
         class59.field1229 = var1;
         class59.field1224 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }
}
