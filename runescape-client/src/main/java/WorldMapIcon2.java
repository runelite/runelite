import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("WorldMapIcon2")
public class WorldMapIcon2 extends AbstractWorldMapIcon {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -985436813
   )
   final int field1034;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   final WorldMapRegion field1035;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -25914375
   )
   @Export("element")
   int element;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   @Export("label")
   WorldMapLabel label;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 927871683
   )
   int field1037;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1431936619
   )
   int field1038;

   @ObfuscatedSignature(
      signature = "(Lhu;Lhu;ILav;)V"
   )
   WorldMapIcon2(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
      super(var1, var2);
      this.field1034 = var3;
      this.field1035 = var4;
      this.method399();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1990181988"
   )
   @Export("getElement")
   public int getElement() {
      return this.element;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Laj;",
      garbageValue = "1159446036"
   )
   @Export("getLabel")
   WorldMapLabel getLabel() {
      return this.label;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "75"
   )
   int vmethod397() {
      return this.field1037;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1558233611"
   )
   int vmethod398() {
      return this.field1038;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-806344204"
   )
   void method399() {
      this.element = class50.getObjectDefinition(this.field1034).transform().mapIconId;
      this.label = this.field1035.method420(ViewportMouse.getWorldMapElement(this.element));
      WorldMapElement var1 = ViewportMouse.getWorldMapElement(this.getElement());
      Sprite var2 = var1.getSprite(false);
      if (var2 != null) {
         this.field1037 = var2.subWidth;
         this.field1038 = var2.subHeight;
      } else {
         this.field1037 = 0;
         this.field1038 = 0;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Lgl;",
      garbageValue = "1026409510"
   )
   static LoginPacket[] method300() {
      return new LoginPacket[]{LoginPacket.field475, LoginPacket.field476, LoginPacket.field473, LoginPacket.field477, LoginPacket.field474};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "16723968"
   )
   public static File method315(String var0) {
      if (!class171.field1117) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class171.field1119.get(var0);
         if (var1 != null) {
            return var1;
         } else {
            File var2 = new File(class171.field1118, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if (!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class171.field1119.put(var0, var2);
                  return var2;
               }
            } catch (Exception var7) {
               try {
                  if (var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var6) {
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(Lbr;IIBB)V",
      garbageValue = "1"
   )
   static final void method316(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.transformedSize();
      if (var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6 && var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
         int var7 = var0.transformedSize();
         Client.field895.approxDestinationX = var1;
         Client.field895.approxDestinationY = var2;
         Client.field895.approxDestinationSizeX = 1;
         Client.field895.approxDestinationSizeY = 1;
         class65 var8 = Client.field895;
         int var9 = NetSocket.calculateRoute(var4, var5, var7, var8, Client.collisionMaps[var0.plane], true, Client.field113, Client.field114);
         if (var9 >= 1) {
            for (int var10 = 0; var10 < var9 - 1; ++var10) {
               var0.method255(Client.field113[var10], Client.field114[var10], var3);
            }
         }
      }

   }
}
