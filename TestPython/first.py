
import matplotlib.pyplot as plt
from matplotlib.lines import Line2D
import numpy as np;

# Tabular data
data = {
    'Step1 - Exception in processing': 58,
    'Step10 - Pricing Set Created (Processing Stopped - Unknown reason)': 7,
    'Step7(1) - Ruleset Response Processed (Processing Stopped - Unknown reason)': 8,
    'Step3(1) - Rules looked up and waiting for resolution (Waiting)': 143,
    'Step10A - Pricingset update (Race Condition)': 147,
    'Step1 - Unprocessed Report': 7,
    'Step3': 29,
    'Step5 - Rule Set lookup': 21,
    'Step6A - Ruleset update race condition ': 3,
    'Step7A - Ruleset exists RS4': 680,
    'Step11 - Success': 2056
}

# Create a figure and axis object
fig, ax = plt.subplots()
# Create a pie chart with labels far away and small font size
wedges, texts, autotexts = ax.pie(data.values(), labels=data.keys(), autopct='%1.1f%%', textprops={'fontsize': 6},
                                  wedgeprops={'linewidth': 2, 'edgecolor': 'white'}, labeldistance=1.2)


# Create legend
#legend_elements = [Line2D([0], [0], marker='o', color='w', label=label, markerfacecolor=color) for label, color in zip(data.keys(), ['#FF0000', '#00FF00', '#0000FF', '#FFFF00', '#00FFFF', '#FF00FF', '#C0C0C0', '#808080'])]
#ax.legend(handles=legend_elements, loc='center left', bbox_to_anchor=(1, 0.5))


# Add count within each slice and lines between slices and labels
for i, wedge in enumerate(wedges):
    x, y = wedge.center
    theta = (wedge.theta2 - wedge.theta1) / 2.0 + wedge.theta1
    dx = 0.5 * wedge.r * np.cos(np.radians(theta))
    dy = 0.5 * wedge.r * np.sin(np.radians(theta))
    label_x, label_y = x + dx, y + dy
    ax.text(label_x, label_y, data[list(data.keys())[i]], ha='center', va='center')
    # Add lines between slices and labels
    tx, ty = texts[i].get_position()
    line = Line2D([x + dx, tx], [y + dy, ty], color='#999999', linewidth=1.5)
    ax.add_line(line)
# Set title and show the plot
ax.set_title('Status Count')
plt.show()
