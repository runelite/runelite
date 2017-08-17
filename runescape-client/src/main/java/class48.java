import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = -44037611
   )
   static int field621;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -891337009
   )
   public static int field625;
   @ObfuscatedName("aw")
   static GarbageCollectorMXBean field618;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -508244459
   )
   int field623;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 699458029
   )
   int field619;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -935258339
   )
   int field626;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 309201499
   )
   int field616;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1224199263
   )
   int field617;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1946243147
   )
   int field628;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -697877929
   )
   int field620;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2102795695
   )
   int field624;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -317297347
   )
   int field615;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 508171089
   )
   int field622;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "122"
   )
   public boolean vmethod762(int var1, int var2) {
      return var1 >= (this.field619 << 6) + (this.field626 << 3) && var1 <= (this.field619 << 6) + (this.field626 << 3) + 7 && var2 >= (this.field620 << 6) + (this.field624 << 3) && var2 <= (this.field620 << 6) + (this.field624 << 3) + 7;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "1"
   )
   public boolean vmethod741(int var1, int var2, int var3) {
      return var1 >= this.field623 && var1 < this.field623 + this.field616?var2 >= (this.field617 << 6) + (this.field628 << 3) && var2 <= (this.field617 << 6) + (this.field628 << 3) + 7 && var3 >= (this.field615 << 6) + (this.field622 << 3) && var3 <= (this.field615 << 6) + (this.field622 << 3) + 7:false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lab;I)V",
      garbageValue = "239959050"
   )
   public void vmethod740(WorldMapData var1) {
      if(var1.field464 > this.field619) {
         var1.field464 = this.field619;
      }

      if(var1.field465 < this.field619) {
         var1.field465 = this.field619;
      }

      if(var1.field460 > this.field620) {
         var1.field460 = this.field620;
      }

      if(var1.field467 < this.field620) {
         var1.field467 = this.field620;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)Lhh;",
      garbageValue = "0"
   )
   public Coordinates vmethod744(int var1, int var2) {
      if(!this.vmethod762(var1, var2)) {
         return null;
      } else {
         int var3 = this.field617 * 64 - this.field619 * 64 + (this.field628 * 8 - this.field626 * 8) + var1;
         int var4 = this.field622 * 8 - this.field624 * 8 + this.field615 * 64 - this.field620 * 64 + var2;
         return new Coordinates(this.field623, var3, var4);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "216213566"
   )
   public int[] vmethod759(int var1, int var2, int var3) {
      if(!this.vmethod741(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field619 * 64 - this.field617 * 64) + (this.field626 * 8 - this.field628 * 8), var3 + (this.field620 * 64 - this.field615 * 64) + (this.field624 * 8 - this.field622 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-2081425823"
   )
   public void vmethod742(Buffer var1) {
      this.field623 = var1.readUnsignedByte();
      this.field616 = var1.readUnsignedByte();
      this.field617 = var1.readUnsignedShort();
      this.field628 = var1.readUnsignedByte();
      this.field615 = var1.readUnsignedShort();
      this.field622 = var1.readUnsignedByte();
      this.field619 = var1.readUnsignedShort();
      this.field626 = var1.readUnsignedByte();
      this.field620 = var1.readUnsignedShort();
      this.field624 = var1.readUnsignedByte();
      this.method763();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1332421159"
   )
   void method763() {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lia;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "1821949939"
   )
   public static void method768(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.getFile(var1);
      int var6 = var0.getChild(var5, var2);
      class66.method1144(var0, var5, var6, var3, var4);
   }
}
