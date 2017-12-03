import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("qf")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("platformInfo")
   static MachineInfo platformInfo;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 1927080309
   )
   static int field577;
   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 211284879
   )
   int field567;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1508782597
   )
   int field568;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 166755823
   )
   int field569;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -448196187
   )
   int field578;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1216943645
   )
   int field571;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1114036995
   )
   int field572;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1741724419
   )
   int field573;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -324377959
   )
   int field570;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1930289661
   )
   int field574;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1495391507
   )
   int field575;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lax;I)V",
      garbageValue = "-2145049745"
   )
   public void vmethod695(WorldMapData var1) {
      if(var1.field424 > this.field571) {
         var1.field424 = this.field571;
      }

      if(var1.field417 < this.field571) {
         var1.field417 = this.field571;
      }

      if(var1.field425 > this.field572) {
         var1.field425 = this.field572;
      }

      if(var1.field431 < this.field572) {
         var1.field431 = this.field572;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1120247978"
   )
   public boolean vmethod708(int var1, int var2, int var3) {
      return var1 >= this.field567 && var1 < this.field567 + this.field568?var2 >= (this.field569 << 6) + (this.field573 << 3) && var2 <= (this.field569 << 6) + (this.field573 << 3) + 7 && var3 >= (this.field578 << 6) + (this.field570 << 3) && var3 <= (this.field578 << 6) + (this.field570 << 3) + 7:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1865125342"
   )
   public boolean vmethod698(int var1, int var2) {
      return var1 >= (this.field571 << 6) + (this.field574 << 3) && var1 <= (this.field571 << 6) + (this.field574 << 3) + 7 && var2 >= (this.field572 << 6) + (this.field575 << 3) && var2 <= (this.field572 << 6) + (this.field575 << 3) + 7;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1197920526"
   )
   public int[] vmethod700(int var1, int var2, int var3) {
      if(!this.vmethod708(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field571 * 64 - this.field569 * 64 + var2 + (this.field574 * 8 - this.field573 * 8), var3 + (this.field572 * 64 - this.field578 * 64) + (this.field575 * 8 - this.field570 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Lhc;",
      garbageValue = "-879620257"
   )
   public Coordinates vmethod714(int var1, int var2) {
      if(!this.vmethod698(var1, var2)) {
         return null;
      } else {
         int var3 = this.field569 * 64 - this.field571 * 64 + (this.field573 * 8 - this.field574 * 8) + var1;
         int var4 = this.field578 * 64 - this.field572 * 64 + var2 + (this.field570 * 8 - this.field575 * 8);
         return new Coordinates(this.field567, var3, var4);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "1638498953"
   )
   public void vmethod701(Buffer var1) {
      this.field567 = var1.readUnsignedByte();
      this.field568 = var1.readUnsignedByte();
      this.field569 = var1.readUnsignedShort();
      this.field573 = var1.readUnsignedByte();
      this.field578 = var1.readUnsignedShort();
      this.field570 = var1.readUnsignedByte();
      this.field571 = var1.readUnsignedShort();
      this.field574 = var1.readUnsignedByte();
      this.field572 = var1.readUnsignedShort();
      this.field575 = var1.readUnsignedByte();
      this.method702();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method702() {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILhi;I)I",
      garbageValue = "-1591173064"
   )
   public static int method720(int var0, class230 var1) {
      return (var0 << 8) + var1.field2905;
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Z",
      garbageValue = "49"
   )
   @Export("isFriended")
   static boolean isFriended(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class221.cleanUsername(var0, PendingSpawn.jagexLoginType);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class221.cleanUsername(Client.friends[var3].name, PendingSpawn.jagexLoginType)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class221.cleanUsername(UrlRequest.localPlayer.name, PendingSpawn.jagexLoginType))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(Lhz;II)Ljava/lang/String;",
      garbageValue = "1759747257"
   )
   static String method717(Widget var0, int var1) {
      int var3 = class36.getWidgetConfig(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && var0.field2859 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
