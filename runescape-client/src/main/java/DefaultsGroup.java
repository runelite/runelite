import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
@Implements("DefaultsGroup")
public class DefaultsGroup {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   @Export("DefaultsGroup_graphics")
   static final DefaultsGroup DefaultsGroup_graphics;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2077113503
   )
   static int field1156;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -800980069
   )
   @Export("group")
   final int group;

   DefaultsGroup(int var1) {
      this.group = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Llj;",
      garbageValue = "-2017595575"
   )
   public static RectangleMode[] method5822() {
      return new RectangleMode[]{RectangleMode.field758, RectangleMode.field757, RectangleMode.field759};
   }

   static {
      DefaultsGroup_graphics = new DefaultsGroup(3);
   }
}
