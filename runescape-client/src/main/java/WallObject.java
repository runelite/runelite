import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("ef")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("nm")
   static byte field2109;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 396011703
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1531671981
   )
   @Export("config")
   int config;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -945213695
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -382955073
   )
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 711197065
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1546000493
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -123148621
   )
   @Export("orientationB")
   int orientationB;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1094089874"
   )
   public static void method2901() {
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var0 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-1734198037"
   )
   public static File method2898(String var0) {
      if(!class157.field2248) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class157.field2246.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class157.field2245, var0);
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
                  class157.field2246.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "1134744167"
   )
   static int method2900(int var0, Script var1, boolean var2) {
      if(var0 == 5306) {
         class81.intStack[++class278.intStackSize - 1] = SceneTilePaint.method2713();
         return 1;
      } else {
         int var3;
         if(var0 == 5307) {
            var3 = class81.intStack[--class278.intStackSize];
            if(var3 == 1 || var3 == 2) {
               Client.field1141 = 0L;
               if(var3 >= 2) {
                  Client.isResized = true;
               } else {
                  Client.isResized = false;
               }

               if(SceneTilePaint.method2713() == 1) {
                  class7.clientInstance.method837(765, 503);
               } else {
                  class7.clientInstance.method837(7680, 2160);
               }

               if(Client.gameState >= 25) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_RESIZE_CLIENT_FRAME);
                  Client.secretPacketBuffer1.putByte(SceneTilePaint.method2713());
                  Client.secretPacketBuffer1.putShort(Timer.canvasWidth);
                  Client.secretPacketBuffer1.putShort(GameEngine.canvasHeight);
               }
            }

            return 1;
         } else if(var0 == 5308) {
            class81.intStack[++class278.intStackSize - 1] = class70.preferences.screenType;
            return 1;
         } else if(var0 != 5309) {
            return 2;
         } else {
            var3 = class81.intStack[--class278.intStackSize];
            if(var3 == 1 || var3 == 2) {
               class70.preferences.screenType = var3;
               WorldMapType3.method215();
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(Lby;IS)V",
      garbageValue = "6203"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class148.method2941(var0.x, var0.y, var1);
   }
}
