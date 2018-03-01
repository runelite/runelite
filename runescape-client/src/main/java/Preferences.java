import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -45446617
   )
   static int field1228;
   @ObfuscatedName("n")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("r")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1452672839
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("y")
   @Export("rememberedUsername")
   String rememberedUsername;
   @ObfuscatedName("k")
   @Export("hideUsername")
   boolean hideUsername;
   @ObfuscatedName("s")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field1228 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      this.method1692(true);
   }

   @ObfuscatedSignature(
      signature = "(Lgy;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1228) {
            if(var1.readUnsignedByte() == 1) {
               this.hideRoofs = true;
            }

            if(var2 > 1) {
               this.muted = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.screenType = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }

            if(var2 > 4) {
               this.rememberedUsername = var1.getNullString();
            }

            if(var2 > 5) {
               this.hideUsername = var1.method3588();
            }
         } else {
            this.method1692(true);
         }
      } else {
         this.method1692(true);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2037677294"
   )
   void method1692(boolean var1) {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Lgy;",
      garbageValue = "72"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1228);
      var1.putByte(this.hideRoofs?1:0);
      var1.putByte(this.muted?1:0);
      var1.putByte(this.screenType);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      var1.putString(this.rememberedUsername != null?this.rememberedUsername:"");
      var1.writeBooleanAsByte(this.hideUsername);
      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljk;I)V",
      garbageValue = "-1463190925"
   )
   public static void method1699(IndexDataBase var0) {
      Overlay.overlay_ref = var0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-64"
   )
   static final void method1691() {
      if(!class132.Viewport_false0) {
         int var0 = Region.pitchSin;
         int var1 = Region.pitchCos;
         int var2 = Region.yawSin;
         int var3 = Region.yawCos;
         byte var4 = 50;
         short var5 = 3500;
         int var6 = (class132.Viewport_mouseX - Graphics3D.centerX) * var4 / Graphics3D.Rasterizer3D_zoom;
         int var7 = (class132.Viewport_mouseY - Graphics3D.centerY) * var4 / Graphics3D.Rasterizer3D_zoom;
         int var8 = (class132.Viewport_mouseX - Graphics3D.centerX) * var5 / Graphics3D.Rasterizer3D_zoom;
         int var9 = (class132.Viewport_mouseY - Graphics3D.centerY) * var5 / Graphics3D.Rasterizer3D_zoom;
         int var10 = Graphics3D.method2867(var7, var4, var1, var0);
         int var11 = Graphics3D.method2868(var7, var4, var1, var0);
         var7 = var10;
         var10 = Graphics3D.method2867(var9, var5, var1, var0);
         int var12 = Graphics3D.method2868(var9, var5, var1, var0);
         var9 = var10;
         var10 = Graphics3D.method2865(var6, var11, var3, var2);
         var11 = Graphics3D.method2848(var6, var11, var3, var2);
         var6 = var10;
         var10 = Graphics3D.method2865(var8, var12, var3, var2);
         var12 = Graphics3D.method2848(var8, var12, var3, var2);
         class95.field1436 = (var10 + var6) / 2;
         class132.field1907 = (var9 + var7) / 2;
         class110.field1591 = (var12 + var11) / 2;
         class132.field1904 = (var10 - var6) / 2;
         class266.field3435 = (var9 - var7) / 2;
         class38.field519 = (var12 - var11) / 2;
         GroundObject.field1781 = Math.abs(class132.field1904);
         class298.field3830 = Math.abs(class266.field3435);
         class171.field2222 = Math.abs(class38.field519);
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Ldt;B)V",
      garbageValue = "-59"
   )
   static final void method1698(TaskDataNode var0) {
      var0.field1639 = false;
      if(var0.data != null) {
         var0.data.int1 = 0;
      }

      for(TaskDataNode var1 = var0.vmethod4438(); var1 != null; var1 = var0.vmethod4433()) {
         method1698(var1);
      }

   }
}
