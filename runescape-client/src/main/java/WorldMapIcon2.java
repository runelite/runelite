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
   @Export("__m")
   final int __m;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   @Export("__f")
   final WorldMapRegion __f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -25914375
   )
   @Export("__q")
   int __q;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   @Export("label0")
   WorldMapLabel label0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 927871683
   )
   @Export("__o")
   int __o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1431936619
   )
   @Export("__u")
   int __u;

   @ObfuscatedSignature(
      signature = "(Lhu;Lhu;ILav;)V"
   )
   WorldMapIcon2(TileLocation var1, TileLocation var2, int var3, WorldMapRegion var4) {
      super(var1, var2);
      this.__m = var3;
      this.__f = var4;
      this.__z_27();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1990181988"
   )
   public int __m_15() {
      return this.__q;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Laj;",
      garbageValue = "1159446036"
   )
   WorldMapLabel __f_16() {
      return this.label0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "75"
   )
   int __q_17() {
      return this.__o;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1558233611"
   )
   int __w_18() {
      return this.__u;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-806344204"
   )
   @Export("__z_27")
   void __z_27() {
      this.__q = class50.getObjectDefinition(this.__m).transform().mapIconId;
      this.label0 = this.__f.__ab_56(ViewportMouse.getWorldMapElement(this.__q));
      WorldMapElement var1 = ViewportMouse.getWorldMapElement(this.__m_15());
      Sprite var2 = var1.getSprite(false);
      if(var2 != null) {
         this.__o = var2.subWidth;
         this.__u = var2.subHeight;
      } else {
         this.__o = 0;
         this.__u = 0;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Lgl;",
      garbageValue = "1026409510"
   )
   static LoginPacket[] method300() {
      return new LoginPacket[]{LoginPacket.__gl_q, LoginPacket.__gl_w, LoginPacket.__gl_m, LoginPacket.__gl_o, LoginPacket.__gl_f};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "16723968"
   )
   public static File method315(String var0) {
      if(!class171.__fo_m) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class171.__fo_q.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class171.__fo_f, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class171.__fo_q.put(var0, var2);
                  return var2;
               }
            } catch (Exception var7) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var6) {
                  ;
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
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6 && var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
         int var7 = var0.transformedSize();
         Client.field895.field2120 = var1;
         Client.field895.field2121 = var2;
         Client.field895.field2122 = 1;
         Client.field895.field2123 = 1;
         class65 var8 = Client.field895;
         int var9 = NetSocket.method3571(var4, var5, var7, var8, Client.collisionMaps[var0.plane], true, Client.__client_tp, Client.__client_th);
         if(var9 >= 1) {
            for(int var10 = 0; var10 < var9 - 1; ++var10) {
               var0.__a_131(Client.__client_tp[var10], Client.__client_th[var10], var3);
            }
         }
      }

   }
}
