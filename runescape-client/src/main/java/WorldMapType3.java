import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 628914285
   )
   int field356;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 264032437
   )
   int field354;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1600677495
   )
   int field355;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1454848645
   )
   int field367;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1286905609
   )
   int field362;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1359389471
   )
   int field361;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2142098025
   )
   int field359;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 627022891
   )
   int field360;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 395773875
   )
   int field358;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -246039889
   )
   int field353;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1362587295
   )
   int field357;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 392164515
   )
   int field364;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -762059459
   )
   int field365;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -110841189
   )
   int field366;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lae;I)V",
      garbageValue = "-1518418003"
   )
   public void vmethod701(WorldMapData var1) {
      if(var1.field426 > this.field362) {
         var1.field426 = this.field362;
      }

      if(var1.field433 < this.field362) {
         var1.field433 = this.field362;
      }

      if(var1.field428 > this.field361) {
         var1.field428 = this.field361;
      }

      if(var1.field422 < this.field361) {
         var1.field422 = this.field361;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-2038931748"
   )
   public boolean vmethod702(int var1, int var2, int var3) {
      return var1 >= this.field356 && var1 < this.field356 + this.field354?var2 >= (this.field355 << 6) + (this.field359 << 3) && var2 <= (this.field355 << 6) + (this.field358 << 3) + 7 && var3 >= (this.field367 << 6) + (this.field360 << 3) && var3 <= (this.field367 << 6) + (this.field353 << 3) + 7:false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1297520065"
   )
   public boolean vmethod703(int var1, int var2) {
      return var1 >= (this.field362 << 6) + (this.field357 << 3) && var1 <= (this.field362 << 6) + (this.field365 << 3) + 7 && var2 >= (this.field361 << 6) + (this.field364 << 3) && var2 <= (this.field361 << 6) + (this.field366 << 3) + 7;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-336358408"
   )
   public int[] vmethod711(int var1, int var2, int var3) {
      if(!this.vmethod702(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field362 * 64 - this.field355 * 64 + var2 + (this.field357 * 8 - this.field359 * 8), var3 + (this.field361 * 64 - this.field367 * 64) + (this.field364 * 8 - this.field360 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Lhn;",
      garbageValue = "1673050917"
   )
   public Coordinates vmethod700(int var1, int var2) {
      if(!this.vmethod703(var1, var2)) {
         return null;
      } else {
         int var3 = this.field355 * 64 - this.field362 * 64 + (this.field359 * 8 - this.field357 * 8) + var1;
         int var4 = this.field367 * 64 - this.field361 * 64 + var2 + (this.field360 * 8 - this.field364 * 8);
         return new Coordinates(this.field356, var3, var4);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgj;B)V",
      garbageValue = "7"
   )
   public void vmethod706(Buffer var1) {
      this.field356 = var1.readUnsignedByte();
      this.field354 = var1.readUnsignedByte();
      this.field355 = var1.readUnsignedShort();
      this.field359 = var1.readUnsignedByte();
      this.field358 = var1.readUnsignedByte();
      this.field367 = var1.readUnsignedShort();
      this.field360 = var1.readUnsignedByte();
      this.field353 = var1.readUnsignedByte();
      this.field362 = var1.readUnsignedShort();
      this.field357 = var1.readUnsignedByte();
      this.field365 = var1.readUnsignedByte();
      this.field361 = var1.readUnsignedShort();
      this.field364 = var1.readUnsignedByte();
      this.field366 = var1.readUnsignedByte();
      this.method200();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   void method200() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-1290944147"
   )
   public static File method222(String var0) {
      if(!class160.field2130) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class160.field2131.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class288.field3760, var0);
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
                  class160.field2131.put(var0, var2);
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-93165682"
   )
   static final void method215() {
      class63.method1054("Your ignore list is full. Max of 100 for free users, and 400 for members");
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-2030401318"
   )
   static void method209(int var0, int var1, int var2, int var3) {
      Widget var4 = class31.getWidgetChild(var0, var1);
      if(var4 != null && var4.field2780 != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.widget = var4;
         var5.objs = var4.field2780;
         class87.method1851(var5);
      }

      Client.field964 = var3;
      Client.spellSelected = true;
      class35.field464 = var0;
      Client.field963 = var1;
      GameCanvas.field603 = var2;
      class60.method1015(var4);
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "68"
   )
   static void method219() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.first(); var0 != null; var0 = (WidgetNode)Client.componentTable.next()) {
         int var1 = var0.id;
         if(class213.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = FileRequest.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class35.getWidget(var4);
               if(var5 != null) {
                  class60.method1015(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("ki")
   @ObfuscatedSignature(
      signature = "(Lho;B)Z",
      garbageValue = "19"
   )
   static boolean method220(Widget var0) {
      if(Client.field977) {
         if(class60.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}
